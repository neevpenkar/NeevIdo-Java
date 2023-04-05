// import java.lang.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Race r = new Race();

        r.getRouteFromSysIn();
        r.getDriversAndCarsFromSysIn();
        r.runRace();
    }
public static void print(String data) {System.out.println(data);}
}
