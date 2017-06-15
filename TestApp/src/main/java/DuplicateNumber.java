/**
 * Created by sujitagarwal on 21/03/17.
 */
import java.util.ArrayList;
import java.util.List;

public class DuplicateNumber {

    public int findDuplicateNumber(List<Integer> numbers){

        int highestNumber = numbers.size() - 1;
        System.out.println("highest number "+highestNumber);
        int total = getSum(numbers);
        System.out.println("total "+total);
        int duplicate = total - (highestNumber*(highestNumber+1)/2);
        return duplicate;
    }

    public int getSum(List<Integer> numbers){

        int sum = 0;
        for(int num:numbers){
            sum += num;
        }
        return sum;
    }

    public static void main(String a[]){
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i=1;i<3;i++){
            numbers.add(i);
        }
        System.out.println(numbers.size());
        //add duplicate number into the list
        numbers.add(24);
        DuplicateNumber dn = new DuplicateNumber();
        System.out.println("Duplicate Number: "+dn.findDuplicateNumber(numbers));
    }
}
