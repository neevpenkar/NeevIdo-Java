public class Race {
    private RaceHandler Handler;

    public Race() {

    }
    public void getRouteFromSysIn() {
        // Step 1: Ask question and Allocate Memory
        int length = getPosInt("How many segments does the route contain? ");
        double[] SegLengths = new double [length];

        // Step 2: Ask for each segment's length
        for (int i = 0; i < length; i++ ) {
            SegLengths[i] = getPosDouble("What is the length of segment " + Integer.toString(i) + " ? " );
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

        this.Handler.calcTimeUpper();
        this.Handler.PrintInfo();
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
