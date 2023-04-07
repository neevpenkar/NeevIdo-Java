
public class Car {
    public String Company;
    public double Accel;
    public double MaxSpeed;
    public Driver Nahag;
    public double raceTime;

    public Car() {}
    public Car(String c, double a, double ms) {
        this.Company = c;
        this.Accel = a;
        this.MaxSpeed = ms;
        this.raceTime = 0;
    }
    public Car (Driver d, String c, double a, double ms) {
        this(c, a, ms);
        this.Nahag = d;
    }

    public void PrintCar() {
        print("---------------");
        this.Nahag.PrintDriver();
        print("---------------");
        print("Manufacturer: " + this.Company);
        print("Acceleration: " + Double.toString(this.Accel));
        print("Maxspeed: " + Double.toString(this.MaxSpeed));
        print("---------------");
    }
    public static void print(String data) {System.out.println(data);}
    public void calcTime(double length) {
        double t0 = this.MaxSpeed / this.Accel;
        double x0 = (this.MaxSpeed * this.MaxSpeed) / (2* this.Accel);

        double t1 = this.MaxSpeed / this.Nahag.BrakeRate;
        double x1 = (this.MaxSpeed * this.MaxSpeed) / (2* this.Nahag.BrakeRate);

        double x2 = length - x0 - x1;
        double t2 = x2 / this.MaxSpeed;

        this.raceTime += t0 + t2 + t1 + this.Nahag.DelayTime;
    }
}
