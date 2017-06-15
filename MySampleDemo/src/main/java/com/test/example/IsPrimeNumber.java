package com.test.example;

import java.util.Scanner;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class IsPrimeNumber {

    public static boolean isPrime(int number)
    {
        for (int i = 2; i <=number/2 ; i++) {
            if(number%i==0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.print("enter number:::");
        Scanner scanner=new Scanner(System.in);
        System.out.println("This number is prime ::"+isPrime(Integer.parseInt(scanner.next())));
    }
}
