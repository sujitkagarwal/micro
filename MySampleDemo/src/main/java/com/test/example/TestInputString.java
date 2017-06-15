package com.test.example;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class TestInputString {
    //119
    //225
    public String addString(String number1, String number2) {
        String result = "";
        char[] ch1 = number1.toCharArray();
        char[] ch2 = number2.toCharArray();
        int divisible = 0;
        for (int i = number1.length() - 1; i >= 0; i--) {
          // int sum=(int)ch1[i]-48+(int)ch2[i]-48+divisible;
           // System.out.println(sum);
           // int sum = Integer.valueOf(ch1[i]+"")+Integer.valueOf(ch2[i]+"")+divisible;
           //int sum=Character.getNumericValue(ch1[i]) + Character.getNumericValue(ch2[i]) + divisible;
            int sum=Integer.parseInt(number1.charAt(i)+"")+Integer.parseInt(number2.charAt(i)+"")+divisible;
            if (sum >= 10) {
                divisible = sum / 10;
                sum = sum % 10;
            } else {
                divisible = 0;
            }
            result = sum + result;
        }
        if(divisible>0)
        return divisible+result;
        else
            return result;
    }

    public static void main(String[] args) {
        TestInputString testInputString = new TestInputString();
        System.out.println(testInputString.addString("119", "225"));
    }



}
