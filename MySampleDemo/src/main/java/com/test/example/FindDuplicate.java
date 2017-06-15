package com.test.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class FindDuplicate {

    public void duplicate(List<Integer> arr) {
        int total = 0;
        int size = arr.size() - 1;
        for (int i : arr) {
            total += i;
        }
        int duplicate = total - size * (size + 1) / 2;
        System.out.println(duplicate);
    }

    private static int getMissingNumber(List<Integer> numbers, int totalCount) {
        int expectedSum = totalCount * (totalCount + 1) / 2;
        int actualSum = 0;
        for (int i : numbers) {
            actualSum += i;
        }
        System.out.println("expected sum="+expectedSum);
        System.out.println("actual sum="+actualSum);
        return expectedSum - actualSum;
    }


    /**
     * A general method to find missing values from an integer array in Java.
     * This method will work even if array has more than one missing element.
     */
    private static void printMissingNumber(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println("last missing bit "+lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }







    public static void main(String[] args) {
        List<Integer> lists = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            lists.add(i);
        }
        lists.add(9);
        FindDuplicate findDuplicate=new FindDuplicate();
        findDuplicate.duplicate(lists);

        List<Integer> lists1 = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++) {
            if(i==6)
            {

            }
            else {
                lists1.add(i);
            }
        }
       // System.out.println(findDuplicate.getMissingNumber(lists1,10));

        // two missing number
        printMissingNumber(new int[]{1, 2, 3, 4, 6, 8, 9, 10}, 10);



    }




}
