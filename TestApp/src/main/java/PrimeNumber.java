import java.util.Scanner;

/**
 * Created by sujitagarwal on 20/03/17.
 */
public class PrimeNumber {

    public static void main(String[] args) {

        PrimeNumber pm=new PrimeNumber();
        System.out.print("Please enter the number ::");
        Scanner scanner=new Scanner(System.in);
       int number= Integer.parseInt(scanner.next());
        System.out.println(pm.prime(number));

    }
    public String prime(int number)
    {
     if(number>1) {
         for (int i = 2; i <= number / 2; i++) {
             if (number % i == 0) {
                 return "Not Prime number ::" + number;
             }
         }
         return "Prime number::" + number;
     }
        return "This number is not consider as prime number "+number;

    }
}
