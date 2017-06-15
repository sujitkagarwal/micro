package com.test.example;

/**
 * Created by sujitagarwal on 31/03/17.
 */
public class RemoveCharacterFromString {

    public static String removeChar(String str,char ch)
    {
        StringBuffer sb=new StringBuffer("");
        Object obh;
        char ch1;
        int m;

        if(str==null)
            return "";
        else
        {
            for (int i = 0; i <= str.length()-1; i++) {
                 ch1=str.charAt(i);
                if(ch1!=ch)
                {
                   sb.append(ch1);
                }

            }
        }

   return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeChar("sujitagarwal",'a'));

    }
}
