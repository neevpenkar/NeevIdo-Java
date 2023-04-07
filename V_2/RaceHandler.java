public class RaceHandler {
    public Car[] carList;
    public Driver[] driverList;
    public int CDlength;

    public double[] timesList;

    public double[] segments;
    public int segmentsLength;

    public RaceHandler(double[] list, int length) {
        this.segmentsLength = length;
        this.segments = new double[length];
        this.segments = list;
    }

    public void update(Car[] c, Driver[] d, int length) {
        this.carList = new Car[length];
        this.driverList = new Driver[length];

        this.carList = c;
        this.driverList = d;

        this.CDlength = length;

        timesList = new double [length];
        for (int i = 0; i < length; i++) {
            timesList[i] = 0;
        }
    }

    public static void print(String data) {System.out.println(data);}
    public void PrintInfo() {
        for (int i = 0; i < CDlength; i++) {
            print(this.driverList[i].Name + "," + this.carList[i].Company + ": " + this.timesList[i]);
        }
    }

    public void calcTimeUpper() {
        for (int c = 0; c < this.CDlength; c++) {
            for(int i = 0; i < segmentsLength; i++) {
                timesList[i] += calcTimeLower(segments[c], i);
            }       
        }
        // for(int j = 0; j < this.CDlength; j++) {
        //     print(this.Cars[j].Nahag.Name + ": " + Double.toString(this.Cars[j].raceTime));
        // }

        // double[] times = new double[this.CDlength];
        // for(int j = 0; j < this.CDlength; j++) {
        //     times[j] = this.Cars[j].raceTime;
        // }
        
        // int indexW = Min(times, this.CDlength);
        // print("The winner is " + this.Cars[indexW].Nahag.Name + "!");
    }

    public double calcTimeLower(double length, int i) {
        double a = this.carList[i].Accel;
        double b = this.driverList[i].BrakeRate;
        double v = this.carList[i].MaxSpeed;
        double del = this.driverList[i].DelayTime;

        // double c = ((v*v) / (2*a)) + ((v*v) / (2*b));
        // if (c > length) {
        //     calcTime2(length);
        //     return;
        // }

        double t0 = v / a;
        double x0 = (v * v) / (2* a);

        double t1 = v / b;
        double x1 = (v * v) / (2* b);

        double x2 = length - x0 - x1;
        double t2 = x2 / v;

        return t0 + t2 + t1 + del;
    }
}