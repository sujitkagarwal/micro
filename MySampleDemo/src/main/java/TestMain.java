/**
 * Created by sujitagarwal on 30/03/17.
 */
public class TestMain {



    public static void main(String[] args) {
       // System.out.println("hello");
        //String number1="1234";
        //char[] ch1 = number1.toCharArray();
        //System.out.println(Integer.valueOf(ch1[0]+""));

        Integer i1 = 127;

        Integer i2 = 127;

        //System.out.println(i1 == i2);

        Integer i3 = 128;

        Integer i4 = 128;

        Integer i5 = 129;

        Integer i6 = 129;


        //System.out.println(i3 == i4);

        //System.out.println(i3.equals(i4));

        //System.out.println(i5 == i6);

        Child child=new Child();
        System.out.println("value of I->"+child.i);

       // Integer i = new Integer(null);

       //System.out.println(i.intValue());//Number Format Exception

        String s = new String();

        int m = 10 + + 11 - - 12 + + 13 - - 14 + + 15;

        System.out.println(m);


        StringBuffer stringBuffer=new StringBuffer("sujit");
        System.out.println(stringBuffer.reverse());

        System.out.println("str substring-->"+"1".substring(1,1));
    }
}

class Parent
{
    static int i = 1111;

    static
    {
        i = i-- - --i;
        System.out.println("parent static"+i);
    }

    {
        i = i++ + ++i;
        System.out.println("parent blank"+i);
    }



}
class Child extends Parent
{



    static
    {
        i = --i - i--;
        System.out.println("child static"+i);
    }

    {
        i = ++i + i++;
        System.out.println("child block"+i);
    }




}