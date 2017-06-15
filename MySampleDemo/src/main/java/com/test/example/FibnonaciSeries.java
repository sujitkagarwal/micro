package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class FibnonaciSeries {

    public static void printFiboo(int number) {

        int arr[] = new int[number];
        arr[0] = 0;
        arr[1] = 1;
        System.out.printf("%d,%d", arr[0], arr[1]);
        for (int i = 2; i < number; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
            System.out.printf(",%d", arr[i]);
        }
    }

    public static void main(String[] args) {
        printFiboo(10);
    }
}
