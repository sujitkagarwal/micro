package inner;

/**
 * Created by sujitagarwal on 27/03/17.
 */
public class ShadowTest {

    public int x = 2;

    static {
        System.out.println("outer static");
    }

    {
        System.out.println("outer blank");
    }

    public ShadowTest() {
        System.out.println("shadow test");
    }

    void methodInFirstLevel(FirstLevel firstLevel) {
        System.out.println("***************");
        System.out.println("x = " + x);
        System.out.println("this.y = " + firstLevel.y);
        System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        System.out.println("***************");
    }


    class FirstLevel {


        {
            System.out.println("inner blank");
        }


        public FirstLevel() {
            System.out.println("inner construction");
        }

        public int x = 1;
        private int y=20;


        void methodInFirstLevel(int x) {
            System.out.println("x = " + x);
            System.out.println("this.x = " + this.x);
            System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
        }
    }

    public static void main(String... args) {
        ShadowTest st = new ShadowTest();
        System.out.println("in main");
        st.methodInFirstLevel(st.new FirstLevel());
        ShadowTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);


    }

}
