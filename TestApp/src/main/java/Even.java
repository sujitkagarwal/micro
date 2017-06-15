/**
 * Created by sujitagarwal on 18/03/17.
 */

public class Even implements Runnable {
    private Object obj;

    public Even(Object obj) {
        this.obj = obj;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {

                System.out.println(i);
                synchronized (obj) {
                    try {

                        obj.notify();
                        obj.wait();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }


            }

        }
    }
}

