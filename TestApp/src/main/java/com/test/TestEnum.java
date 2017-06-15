package com.test;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class TestEnum {
    public static void main(String[] args) {
        MachineState machineState = MachineState.BUSY;
        System.out.println(machineState);
        MachineState machineState1 = MachineState.BUSY;
        MachineState machineState2 = MachineState.BLOCKED;
        System.out.println(machineState == machineState1);
        System.out.println(machineState.equals(machineState1));
        System.out.println(machineState == machineState2);
        System.out.println(machineState.equals(machineState2));
        MachineState state[] = MachineState.values();
        for (MachineState state1 : state) {
            System.out.println(state1);
        }
    }
}
