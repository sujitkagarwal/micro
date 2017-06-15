package unmodifiedcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sujitagarwal on 04/04/17.
 */
public class TesUnModifiedCollection {

    public static void main(String[] args) {
        final List<String> modifiable = new ArrayList<>();
        modifiable.add("Java");
        modifiable.add("is");

        final List<String> unmodifiable = Collections.unmodifiableList(modifiable);
        System.out.println("Before modification: " + unmodifiable);

        modifiable.add("the");
        modifiable.add("best");

        System.out.println("After modification: " + unmodifiable);

    }

}
