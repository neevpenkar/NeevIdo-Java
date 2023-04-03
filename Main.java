// // import java.lang.*;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         int i;
//         System.out.println("Hello Word");
//         i = getPosInt("pls enter int: ");
        
//         System.out.println("User: " + i);
//     }
// public static void print(String data) {System.out.println(data);}
// public static int getPosInt(String data){
//     int i;
//     Scanner obj = new Scanner(System.in);
//     try {
//         print(data);
//         i = obj.nextInt();
//         if (i < 0) {
//             print("Input must be a positive integer, got " + Integer.toString(i) );
//             i = getPosInt(data);
//             obj.close();
//         }
//     }
//     catch(Exception e) {
//         obj.close();
//         i = getPosInt(data);
//     }
//     return i;
// }
// }
