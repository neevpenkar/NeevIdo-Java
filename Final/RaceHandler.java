public class RaceHandler {
    public Car[] carList;
    public Driver[] driverList;
    public int CDlength;

    public double[] timesList;

    public double[] segmentList;
    public int segmentsLength;

//    ##########################################
    public RaceHandler(double[] list, int length) {
        this.segmentsLength = length;
        this.segmentList = new double[length];
        this.segmentList = list;
    }
    public RaceHandler() {
        this.segmentsLength = 0;
        this.segmentList = null;
    }

//    #################################### 
    public void changeSegments(double[] list, int length) {
        this.segmentsLength = length;
        this.segmentList = new double[length];
        this.segmentList = list;
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
    public Car[] getCarList () {return this.carList;}
    public Driver[] getDriverList () {return this.driverList;}

    public static void print(String data) {System.out.println(data);}
    public void PrintInfo() {
        for (int i = 0; i < CDlength; i++) {
            print(this.driverList[i].Name + "," + this.carList[i].Company + "," + this.timesList[i]);
        }
    }

    public Driver calcTimeUpper() {
        for (int c = 0; c < this.CDlength; c++) {
            for(int i = 0; i < segmentsLength; i++) {
                timesList[c] += calcTimeLower(segmentList[i], c);
            }
            timesList[c] -= this.driverList[c].DelayTime;
        }
            
        return this.driverList[Min(timesList, this.CDlength)];
    }

    public double calcTimeLower(double length, int i) {
        double a = this.carList[i].Accel; // a = 5
        double b = this.driverList[i].BrakeRate; // b = 3
        double v = this.carList[i].MaxSpeed; // v = 15
        double del = this.driverList[i].DelayTime; // 1

        double c = ((v*v) / (2*a)) + ((v*v) / (2*b)); // 
        if (c > length) {
            return calcTime2(length, i);
        }

        double t0 = v / a; // 5
        double x0 = (v * v) / (2* a); // 25

        double t1 = v / b; // 10
        double x1 = (v * v) / (2* b); // 50

        double x2 = length - x0 - x1; // 100 - 25 - 50 = 25
        double t2 = x2 / v; // 25 / 210 = 2.5

        return t0 + t2 + t1 + del; // 2.5 + 5 + 10 + 1 = 18.5
    }

    public double calcTime2(double length, int i) {
        double a = this.carList[i].Accel;
        double b = this.driverList[i].BrakeRate;
        double v = this.carList[i].MaxSpeed;
        double del = this.driverList[i].DelayTime;

        double v1 = Math.sqrt( (2 * a * b) / (a + b) );
        
        double t = this.carList[i].MaxSpeed;
        this.carList[i].MaxSpeed = v1;
        double o = calcTimeLower(length + 0.0001, i);
        this.carList[i].MaxSpeed = t;
        return o;
    }

    public void Sort() {

        for (int j = 0; j < CDlength; j++) {
            for (int i = 0; i < CDlength - j - 1; i++) {
                if ( timesList[i] > timesList[i + 1] ) {
                    // Swap i, i+1
                    double temp1 = timesList[i];
                    timesList[i] = timesList[i+1];
                    timesList[i+1] = temp1;

                    Car temp2 = carList[i];
                    carList[i] = carList[i+1];
                    carList[i+1] = temp2;

                    Driver temp3 = driverList[i];
                    driverList[i] = driverList[i+1];
                    driverList[i+1] = temp3;
                }
            }
        }
    }

    public static int Min(double[] arr, int length) {
        // Returns the index of the min object
        int index = 0;

        for (int i = 0; i < length; i++) {
            if ( arr[i] < arr[index] ) index = i;
        }

        return index;
    }
}