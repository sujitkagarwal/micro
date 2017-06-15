/**
 * Created by sujitagarwal on 21/03/17.
 */
public class MaxTwoNumber {

    public void findNumber(int arr[])
    {
        int maxNumberOne=0;
        int maxNumberTwo=0;
        for (int num:arr)
        {
            if(maxNumberOne<num)
            {
                maxNumberTwo=maxNumberOne;
                maxNumberOne=num;
            }
            else{
                if(maxNumberTwo<num)
                {
                    maxNumberTwo=num;
                }

            }

        }
        System.out.println(maxNumberOne    +"      "+maxNumberTwo);

    }

    public static void main(String[] args) {

        int arr[]={10,60,90};
        MaxTwoNumber maxTwoNumber=new MaxTwoNumber();
        maxTwoNumber.findNumber(arr);

    }
}
