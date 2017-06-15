package com.test.example;

/**
 * Created by sujitagarwal on 30/03/17.
 */
public class ReserveString {

    public String reverse(String str) {
        String reverse = null;
        if (str.length() == 1) {
            return str;
        } else {

            reverse = str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
            return reverse;

        }
    }

    public static void main(String[] args) {
        ReserveString  reserveString=new ReserveString();
        System.out.println(reserveString.reverse("sujit"));
    }
}
