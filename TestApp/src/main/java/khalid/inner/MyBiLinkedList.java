package khalid.inner;

/**
 * Created by sujitagarwal on 27/03/17.
 */
public class MyBiLinkedList implements ListPool.IBiLink { // (6)

    ListPool.MyLinkedList.BiNode objRef = new ListPool.MyLinkedList.BiNode(); // (7)
    //ListPool.MyLinkedList.ILink ref; // (8) Compile-time error!
}
