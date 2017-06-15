import org.junit.Test;

/**
 * Created by sujitagarwal on 20/03/17.
 */
public class TestJunit {

    @Test
    public void queueTest() {
        GenQueue<String> tester = new GenQueue<String>(); // MyClass is tested

        tester.enqueue("sujit");
        tester.enqueue("agarwal");
        System.out.println(tester.dequeue());
        System.out.println(tester.dequeue());
        System.out.println(tester.dequeue());
    }

    @Test
    public void stackTest() {

        Stack<String> stringStack=new Stack<String>(4);
        stringStack.push("A");
        stringStack.push("B");
        stringStack.push("C");
        stringStack.push("D");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
    }

}
