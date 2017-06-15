package com.test.example;

import java.util.BitSet;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class TestBitSet {

    public static void main(String[] args) {

        BitSet bitset1 = new BitSet(8);
        BitSet bitset2 = new BitSet(8);

        // assign values to bitset1
        bitset1.set(0);
        bitset1.set(1);
        bitset1.set(2);
       // bitset1.set(3);
        bitset1.set(4);
        bitset1.set(5);

        // assign values to bitset2
        bitset2.set(2);
        bitset2.set(4);
        bitset2.set(6);
        bitset2.set(8);
        bitset2.set(10);

        // print the sets
        System.out.println("Bitset1:" + bitset1);
        System.out.println("Bitset2:" + bitset2);

        // print the first set bit of bitset1
        System.out.println("" + bitset1.nextClearBit(0));

        // print the first set bit of bitset2 after index 5
        System.out.println("" + bitset2.nextClearBit(2));
        System.out.println("" + bitset2.nextClearBit(8));
        for (int i = 0; i <bitset2.length() ; i++) {
            System.out.println(bitset2.nextClearBit(i));

        }
    }


}
