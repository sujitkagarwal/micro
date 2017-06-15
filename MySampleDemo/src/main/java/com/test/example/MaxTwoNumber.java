package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class MaxTwoNumber {

    public static void maxNumber(int arr[]) {
        int maxOne = 0;
        int maxTwo = 0;
        int number = 0;
        for (int i = 0; i <= arr.length-1; i++) {
            number = arr[i];
            if (maxOne < number) {
                maxTwo = maxOne;
                maxOne = number;
            } else if(maxTwo<number) {
                maxTwo = number;
            }

        }
        System.out.printf(" %d ,%d ",maxOne,maxTwo);
    }

    public static void main(String[] args) {
        maxNumber(new int[]{10,2,19,40});
    }
}
