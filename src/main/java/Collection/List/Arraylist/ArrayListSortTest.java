package Collection.List.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayListSortTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //Sorting
        System.out.println("");
        System.out.println("Sorting elements");

        //Pass null as an argument to sort
        //If sorting primitives
        //or objects implementing comparable interface

        //Pass comparator object as an argument to sort()
        //if sorting objects for those a specific comparator class is defined.

        myList.sort(null);
        myList.forEach(list -> System.out.print(list + ", ") );
    }
}

