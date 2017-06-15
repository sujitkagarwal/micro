import java.util.ArrayList;
import java.util.List;

/**
 * Created by sujitagarwal on 25/03/17.
 */
public class TestStatic {

    static String setData() {
        System.out.println("hello static");
        return "hello";
    }


    static String getData() {
        System.out.println("getData");

return "sujit";
    }

    public static void main(String[] args) {


       /* TestStatic testStatic=null;
        String s=testStatic.setData();
        System.out.println(s);

        String m=setData();
        System.out.println(m);

        */
        for (int i = 0; i <= 4; i++) {
            switch (i) {
                case 1: {
                    System.out.println(i);
                }
                case 2: {
                    System.out.println(i);
                    break;
                }
                case 3: {
                    System.out.println(i);
                }
                default: {
                    System.out.println("default"+i);
                }

            }
        }
        List<?> ref=null;
        List<String> strList=new ArrayList<String>();
        List<Object> obhList=new ArrayList<Object>();
        List<Integer> intList=new ArrayList<Integer>();
        ref=strList;
      //  obhList=strList;
       // obhList=intList;
       // intList=strList;



        System.out.println("*************");
            try {
                getData();

            } catch (Exception e) {
                System.out.println("exception");
            } finally {
                System.out.println("finally");
            }
        }
    }

