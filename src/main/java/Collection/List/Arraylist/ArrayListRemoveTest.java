package Collection.List.Arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayListRemoveTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //Remove removes elements from a specific index.
        System.out.println("");
        System.out.println("REMOVING ELEMENT FROM 1ST INDEX");
        myList.remove(0);
        myList.forEach(list -> System.out.print(list + ", ") );
        System.out.println("");
        myList.remove(new Integer(96));
        myList.forEach(list -> System.out.print(list + ", ") );

        System.out.println("");
        //RemoveAll removes all elements from a list provided as an argument(collection) to it
        System.out.println("REMOVING A COLLECTION FROM LIST");
        myList.removeAll(Arrays.asList(97, 96));
        myList.removeAll(new HashSet<>(Arrays.asList(95, 94, 94)));
        myList.forEach(list -> System.out.print(list + ", ") );

        //Retain keeps elements in a list provided as an argument(collection) to it
        //removes rest of the elements
        System.out.println("");
        System.out.println("RETAIN A COLLECTION IN A LIST");
        myList.retainAll(Arrays.asList(92, 91, 90, 89, 88));
        myList.retainAll(new HashSet<>(Arrays.asList(91, 91, 90, 89, 88)));
        myList.forEach(list -> System.out.print(list + ", ") );

        System.out.println("");
        System.out.println("CLEAR/REMOVEALL A LIST");
        myList.clear();
        myList.forEach(list -> System.out.print(list + ", ") );
    }
}

