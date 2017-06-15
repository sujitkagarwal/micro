/**
 * Created by sujitagarwal on 22/03/17.
 */
public class MyFibonacci {

    public static void main(String a[]){

        int febCount = 15;
        int[] feb = new int[febCount];
        feb[0] = 0;
        feb[1] = 1;
        System.out.print(feb[0] + " ");
        System.out.print(feb[1] + " ");
        for(int i=2; i < febCount; i++){
            feb[i] = feb[i-2]+feb[i-1];
            System.out.print(feb[i] + " ");
        }

       /* for(int i=0; i< febCount; i++){
            System.out.print(feb[i] + " ");
        }*/
    }
}
