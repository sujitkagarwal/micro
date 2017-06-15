/**
 * Created by sujitagarwal on 20/03/17.
 */
public class Stack<T> {

    T[] elementArray;
    int top = -1;
    public Stack(int size) {
        elementArray = (T[]) new Object[size];
    }
    public void push(T ele) {
        // System.out.println("top  "+top);
        if (top + 1 >= elementArray.length) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        } else {
            elementArray[++top] = ele;
        }
    }
    public T pop() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("under flow Exception");
        }
        return elementArray[top--];
    }

}
