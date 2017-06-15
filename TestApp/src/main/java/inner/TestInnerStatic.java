package inner;

/**
 * Created by sujitagarwal on 04/04/17.
 */
public class TestInnerStatic {

    public int age = 0;


    static {
        System.out.println("outer static");
    }

    {
        System.out.println("outer blank");
    }

    public TestInnerStatic()
    {
        System.out.println("outer constructor");
    }

    public int getAge() {
        return this.age;
    }
    public void setPrint(InnerStatic  innerStatic)
    {

        System.out.println(this.age);
        System.out.println(innerStatic.age);
    }

    static class  InnerStatic{

          private static int age=10;

        static {
            System.out.println("inner static");
            System.out.println("inner static");
        }
        {
            System.out.println("inner blank");
        }
        public InnerStatic()
        {
            System.out.println("");
        }
        public int getAge() {
            return this.age;
        }
    }
}
