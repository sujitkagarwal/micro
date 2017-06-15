/**
 * Created by sujitagarwal on 18/03/17.
 */
public class TestMain {

    public static void main(String srg[]) throws Exception {

        Object obj = new Object();
        Odd odd = new Odd(obj);
        Thread th = new Thread(odd);
        th.start();

        Even even = new Even(obj);
        Thread th1 = new Thread(even);
        th1.start();

    }
}
