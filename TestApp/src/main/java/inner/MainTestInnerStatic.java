package inner;

/**
 * Created by sujitagarwal on 04/04/17.
 */
public class MainTestInnerStatic {
    public static void main(String[] args) {
        TestInnerStatic  testInnerStatic=new TestInnerStatic();

        System.out.println("afetr outer creation");

        //TestInnerStatic.InnerStatic innerStatic1=testInnerStatic.new InnerStatic();

        TestInnerStatic.InnerStatic innerStatic=new TestInnerStatic.InnerStatic() ;
        System.out.println(innerStatic.getAge());
    }
}
