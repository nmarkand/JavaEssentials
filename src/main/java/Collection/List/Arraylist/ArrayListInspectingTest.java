package Collection.List.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListInspectingTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        System.out.println("ADDING ELEMENTS TO LIST");
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //contains check if element exists in a list or not
        System.out.println("");
        System.out.println(myList.contains(98));

        //containsAll check if all the elements of argument collection exists in a list or not
        System.out.println("");
        System.out.println(myList.containsAll(Arrays.asList(98,97,88,89)));

        //indexOf gives index of an element in a list
        System.out.println("");
        System.out.println(myList.indexOf(93));

        //lastIndexOf gives last index of element in case if it is present multiple times in a list
        System.out.println("");
        System.out.println(myList.lastIndexOf(98));

        System.out.println(myList.isEmpty());

        System.out.println(myList.size());
    }
}

