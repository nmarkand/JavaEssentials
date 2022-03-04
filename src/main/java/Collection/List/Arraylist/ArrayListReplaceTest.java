package Collection.List.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayListReplaceTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        System.out.println("ADDING ELEMENTS TO LIST");
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //SET replaces an element from a specific index
        System.out.println("");
        System.out.println("SET SETTING/REPLACING AN ELEMENT ON 1ST INDEX");
        myList.set(1, 0);
        myList.forEach(list -> System.out.print(list + ", "));

        //REPLACEALL takes a lambda expression and replaces elements of
        //list with the result of that lambda expression
        System.out.println("");
        System.out.println("REPLACEALL ELEMENTS");
        myList.replaceAll(element -> element + 1);
        myList.forEach(list -> System.out.print(list + ", "));
    }
}

