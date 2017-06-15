package com.test.example;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class PerfectNumber {
    public boolean isPerfect(int number)
    {
        boolean status=false;
        int temp=0;
        for(int i=1;i<=number/2;i++)
        {
            if(number%i==0)
            {
                temp+=i;
            }
        }
        if(temp==number)
           return true;

        return status;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectNumber().isPerfect(28));
    }
}