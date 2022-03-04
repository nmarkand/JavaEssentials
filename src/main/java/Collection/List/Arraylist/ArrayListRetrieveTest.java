package Collection.List.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListRetrieveTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        System.out.println("ADDING ELEMENTS TO LIST");
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //get element from a specific index
        System.out.println("");
        System.out.println(myList.get(3));

        //subList retrieves a list from an index to before other index
        System.out.println("");
        System.out.println(myList.subList(1,4));
    }
}

