import java.util.Scanner;
public class Race {

    // TODO: you may add fields and methods as required.
    private int Segments;
    private double[] SegLengths;

    public Race(){
        // TODO: if you have added fields to the class, initialize them here.
    }

    public void getRouteFromSysIn(){
        // A procedure to get a route from the user.
        
        // Step 1: Ask question and Allocate Memory
        this.Segments = getPosInt("How many segments does the route contain?");
        this.SegLengths = new double [this.Segments];

        // Step 2: Ask for each segment's length
        for (int i = 0; i < this.Segments; i++ ) {
            this.SegLengths[i] = getPosDouble("What is the length of segment" + Integer.toString(i) + "?");
        }

    }

    public void getDriversAndCarsFromSysIn(){
        // A procedure to get the lists of drivers and cars from the user.

        // TODO: implement here the code for getting from the user the list of
        //  drivers and cars in the race. See example for expected behaviour in
        //  the assignment description.
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
    public static int getPosInt(String data){
        int i;
        Scanner obj = new Scanner(System.in);
        try {
            print(data);
            i = obj.nextInt();
            if (i < 0) {
                print("Input must be a positive integer, got " + Integer.toString(i) );
                i = getPosInt(data);
                obj.close();
            }
        }
        catch(Exception e) {
            obj.close();
            i = getPosInt(data);
        }
        return i;
    }
    public static double getPosDouble(String data){
        double i;
        Scanner obj = new Scanner(System.in);
        try {
            print(data);
            i = obj.nextDouble();
            if (i < 0) {
                print("Input must be a positive Double, got " + Double.toString(i) );
                i = getPosDouble(data);
                obj.close();
            }
        }
        catch(Exception e) {
            obj.close();
            i = getPosDouble(data);
        }
        return i;
    }
}