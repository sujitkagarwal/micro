/**
 * Created by sujitagarwal on 21/03/17.
 */
public class ReverseString {


   public  String reverse(String str)
    {
        if(str.length()==1)
        {
            return str;
        }
        else
        {
        str=str.charAt(str.length()-1)+reverse(str.substring(0,str.length()-1));
        return str;
        }

    }


    public static void main(String[] args) {
        ReverseString  reverseString=new ReverseString();
        System.out.println(reverseString.reverse("sujit"));

    }
}
