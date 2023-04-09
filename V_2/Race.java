import java.util.Scanner;
import java.util.Scanner;

public class Race {
    private RaceHandler Handler;
    private static int instances;
    private static Scanner sc = new Scanner(System.in);

    static {
        instances = 0;
    }

    public Race() {
        instances += 1;
    }
    public void getRouteFromSysIn() {
        // Step 1: Ask question and Allocate Memory
        int length = getPosInt("How many segments does the route contain? ");
        double[] SegLengths = new double [length];

        // Step 2: Ask for each segment's length
        for (int i = 0; i < length; i++ ) {
            String t = "What is the length of segment " + Integer.toString(i) + " ? ";
            SegLengths[i] = getPosDouble(t);
        }

        this.Handler = new RaceHandler(SegLengths, length);
    }

    public void getDriversAndCarsFromSysIn(){
        int tl = getPosInt("How many participants are there in the race?");
        Driver[] Drivers = new Driver[tl];
        Car[] Cars = new Car[tl];

        for (int i = 0; i < tl; i++) {
            print("Please enter details for driver " + Integer.toString(i) +" :");
            String temp1 = getString("What is the driver's name? ");
            double temp2 = getPosDouble("What is the driver's braking rate? ");
            double temp3 = getPosDouble("What is the driver's delay time? ");
            
            // String temp1 = "Ido";
            // double temp2 = 10;
            // double temp3 = 0.000001;

            Drivers[i] = new Driver(temp1, temp2, temp3);
        }

        for (int i = 0; i < tl; i++) {
            print("Please enter details for car " + Integer.toString(i) +" :");
            String temp1 = getString("What is the car's manufacturer? ");
            double temp2 = getPosDouble("What is the car's acceleration? ");
            double temp3 = getPosDouble("What is the car's maximum speed? ");
            
            // String temp1 = "Lambo";
            // double temp2 = 10;
            // double temp3 = 20;

            Cars[i] = new Car(temp1, temp2, temp3);
        }

        this.Handler.update(Cars, Drivers, tl);
    }

    public void runRace() {
        // A procedure to compute and print the time which took each user to
        // complete the route, and to print the winner.

        Driver d = this.Handler.calcTimeUpper();
        this.Handler.PrintInfo();
        print("The winner is: " + d.Name + "!");
    }

    public void runAllPairsRace() {
        // 
        Car[] tempC = this.Handler.getCarList();
        Driver[] tempD = this.Handler.getDriverList();
        int len = this.Handler.CDlength;

        // New Arrays
        Car[] newCars = new Car[len*len];
        Driver[] newDrivers = new Driver[len*len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int target = i*len + j;
                newCars[target] = tempC[j];
                newDrivers[target] = tempD[i];
            }
        }

        RaceHandler temp = this.Handler;
        temp.update(newCars, newDrivers, len*len);
        temp.calcTimeUpper();

        int win = RaceHandler.Min(temp.timesList, temp.CDlength);
        temp.PrintInfo();

        print("The winning pair is " + temp.getDriverList()[win].Name + " and " + temp.getCarList()[win].Company + " , who completed the race in " + Double.toString(temp.timesList[win]) + " seconds!");
    }

    public void printTotalInstantiatedRaces() {
        // Prints the total number of instantiated Race objects throughout the
        // run of the program.

        print("The number of constructed Race instances is " + Integer.toString(instances));
    }

    public void runRaceWithSortedOutput() {
        // A bonus question: same as runRace, with the exception that the list
        // of drivers should be printed with increasing times.

        Driver d = this.Handler.calcTimeUpper();
        this.Handler.Sort();
        this.Handler.PrintInfo();
        print("The winner is: " + d.Name + "!");
    }


    // #######################################################################

    public static void print(String data) {System.out.println(data);}
    public static int getPosInt(String data) {
        print(data);
        int i = sc.nextInt();
        // sc.nextLine();
        print(Integer.toString(i));

        if (i <= 0) {
            // sc.close();
            // 
            return getPosInt(data);
        }
        // sc.close();
        return i;
    }
    public static double getPosDouble(String prompt) {
        double value = 0.0;
        boolean validInput = false;
        do {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                if (value > 0) {
                    validInput = true;
                } else {
                    System.out.println("Error: Value must be positive.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a valid positive number.");
                sc.next(); // consume invalid input
            }
        } while (!validInput);
        return value;
    }
    
    public static String getString(String data) {
        print(data);
        String t = sc.nextLine();
        // sc.close();
        return t;
    }
}
