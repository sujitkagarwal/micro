package com.test.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class FindNumberINArray {

    public void printSequence(int arr[], int number) {
        if (arr.length > 2) {
            Arrays.sort(arr);
            int leftIndex = 0;
            int rightIndex = arr.length - 1;
            int sum = 0;
            for (int a : arr) {
                if (leftIndex < rightIndex) {
                    sum = arr[leftIndex] + arr[rightIndex];
                    if (sum == number) {
                        System.out.printf("(%d , %d) %n", arr[leftIndex], arr[rightIndex]);
                        leftIndex++;
                        rightIndex--;
                    } else if (sum < number) {
                        leftIndex++;
                    }
                    else{
                        rightIndex--;
                    }

                }


            }


        }


    }

public void printSq(int arr[],int number)
{
        int target;
     Set<Integer> list=new HashSet<Integer>();
    for (int i = 0; i < arr.length; i++) {

        target=number-arr[i];
        if(!list.contains(target))
        {
            list.add(arr[i]);
        }
        else
        {
            System.out.printf("(%d ,%d) %n",target,arr[i]);
        }
    }


}




    public static void main(String[] args) {
        int arr[]={2,3,6,7,9,2,4};
        new FindNumberINArray().printSequence(arr,9);
        new FindNumberINArray().printSq(arr,9);
    }
}
