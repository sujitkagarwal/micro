package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class PrintOddEven {



    public static void main(String[] args) {
        final Object obj = new Object();
        Runnable r = () -> {
            for (int i = 1; i <=10 ; i++) {
                if(i%2!=0)
                {
                    System.out.println(i);
                    synchronized (obj)
                    {
                        try{
                            obj.notify();
                            obj.wait();

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

       Thread thread=new Thread(r);
        thread.start();


        Runnable r1 = () -> {
            for (int i = 1; i <=10 ; i++) {
                if(i%2==0)
                {
                    System.out.println(i);
                    synchronized (obj)
                    {
                        try{
                            obj.notify();
                            obj.wait();

                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Thread thread1=new Thread(r1);
        thread1.start();

    }
}
