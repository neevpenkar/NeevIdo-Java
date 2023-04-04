
public class Race {

    // TODO: you may add fields and methods as required.
    private int Segments;
    private double[] SegLengths;

    private int DriversLen;
    private Driver[] Drivers;

    private Car[] Cars;

    public Race(){
        // TODO: if you have added fields to the class, initialize them here.
    }

    public void getRouteFromSysIn(){
        // A procedure to get a route from the user.
        
        // Step 1: Ask question and Allocate Memory
        this.Segments = getPosInt("How many segments does the route contain? ");
        this.SegLengths = new double [this.Segments];

        // Step 2: Ask for each segment's length
        for (int i = 0; i < this.Segments; i++ ) {
            this.SegLengths[i] = getPosDouble("What is the length of segment " + Integer.toString(i) + " clc? " );
        }

    }

    public void getDriversAndCarsFromSysIn(){
        // A procedure to get the lists of drivers and cars from the user.
        this.DriversLen = getPosInt("How many participants are there in the race?");
        this.Drivers = new Driver[this.DriversLen];
        this.Cars = new Car[this.DriversLen];

        // for (int i = 0; i < this.DriversLen; i++) {
        //     print("Please enter details for driver " + Integer.toString(i) +" :");
        //     String temp1 = getString("What is the driver's name? ");
        //     double temp2 = getPosDouble("What is the driver's braking rate? ");
        //     double temp3 = getPosDouble("What is the driver's delay time? ");

        //     this.Drivers[i] = new Driver(temp1, temp2, temp3);
        // }

        for (int i = 0; i < this.DriversLen; i++) {
            print("Please enter details for car " + Integer.toString(i) +" :");
            String temp1 = getString("What is the car's manufacturer? ");
            double temp2 = getPosDouble("What is the car's acceleration? ");
            double temp3 = getPosDouble("What is the car's maximum speed? ");
            
            this.Cars[i] = new Car(temp1, temp2, temp3);
        }

        for (int i = 0; i < this.DriversLen; i++) {
            this.Drivers[i].PrintDriver();
        }
        for (int i = 0; i < this.DriversLen; i++) {
            this.Cars[i].PrintCar();
        }
    }

    public void runRace() {
        // A procedure to compute and print the time which took each user to
        // complete the route, and to print the winner.

        // TODO: implement here the code question 1 in the assignment. See example
        //  for expected behaviour in the assignment description.
    }

    public void runAllPairsRace() {
        // A similar procedure to runRace, which consider all driver-car pairs.

        // TODO: implement here the code question 2 in the assignment. See example
        //  for expected behaviour in the assignment description.
    }

    public void printTotalInstantiatedRaces() {
        // Prints the total number of instantiated Race objects throughout the
        // run of the program.

        // TODO: implement here the code question 3 in the assignment. See example
        //  for expected behaviour in the assignment description.
    }

    public void runRaceWithSortedOutput() {
        // A bonus question: same as runRace, with the exception that the list
        // of drivers should be printed with increasing times.

        // TODO: implement here the code question 4 in the assignment. See example
        //  for expected behaviour in the assignment description.
    }
    public static void print(String data) {System.out.println(data);}
    public static int getPosInt(String data) {
        int i = 0;
        UserInput ui = new UserInput();
        i = ui.getInt(data);
        if (i <= 0) {
            print("Input must be a positive Int, got " + Integer.toString(i));
            return getPosInt(data);
        }
        return i;
    }
    public static double getPosDouble(String data) {
        double i = 0;
        UserInput ui = new UserInput();
        i = ui.getDouble(data);
        if (i <= 0) {
            print("Input must be a positive Double, got " + Double.toString(i));
            return getPosDouble(data);
        }
        return i;
    }

    public static String getString(String data) {
        UserInput ui = new UserInput();
        return ui.getString(data);
    }
}