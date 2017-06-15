package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class ReverseNumber {
    public int reverseNumber(int number)
    {
        int reverseNumber=0;
        String s=number+"";
        while(number!=0) {
            reverseNumber=reverseNumber*10+number%10;
            number=number/10;
        }
        return reverseNumber;
    }

    public static void main(String[] args) {
        System.out.println( new ReverseNumber().reverseNumber(12657));
    }

}
