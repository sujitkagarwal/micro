package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class Stack<T> {
    T[] arr;
    int top=-1;
    public Stack(int length)
    {
        arr=(T[])new Object[length];
    }
    public void push(T element)
    {
        if(top+1==arr.length)
            throw new RuntimeException("stack over flow");
        else
            arr[++top]=element;

    }

    public T pop()
    {
        if(top==-1)
            throw new RuntimeException("under flow");
        return arr[top--];
    }

    public static void main(String[] args) {
        Stack<String> s=new Stack<String>(3);
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push("d");
        System.out.println(s.pop());
       // System.out.println(s.pop());

    }
}
