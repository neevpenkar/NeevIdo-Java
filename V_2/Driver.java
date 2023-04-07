public class Driver {
    public String Name;
    public double BrakeRate;
    public double DelayTime;
    
    public Driver() {}
    public Driver (String n, double br, double dt) {
        this.Name = n;
        this.BrakeRate = br;
        this.DelayTime = dt;
    }
    public void PrintDriver() {
        print("Name: " + this.Name);
        print("Braking Rate: " + Double.toString(this.BrakeRate));
        print("Delay Time: " + Double.toString(this.DelayTime));
    }
    public static void print(String data) {System.out.println(data);}
}
