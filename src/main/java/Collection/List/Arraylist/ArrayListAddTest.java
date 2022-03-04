package Collection.List.Arraylist;

import java.util.*;

public class ArrayListAddTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        System.out.println("METHODS FROM COLLECTION INTERFACE");
        //Add used to add an element at the last index.
        myList.add(99);
        myList.addAll(Arrays.asList(98,97,96,95));
        myList.forEach(list -> System.out.print(list + ", ") );

        System.out.println("");
        //ADD/ADDALL with index adds elements to a particular index if that index is
        // present/element is present at that index
        //otherwise ArrayIndexOutofBound exception occurs
        //if elements added then existing element of that index shifts to right position.

        System.out.println("METHODS FROM LIST INTERFACE");
        myList.addAll(1, Arrays.asList(1,2,3,4));
        myList.addAll(2, Arrays.asList(6,5));

        System.out.println("");

        //IT WONT WORK BECAUSE AT INDEX 88 THERE IS NO ELEMENT PRESENT ALREADY
        //ADDALL() CAN ADD ELEMENT TO AN INDEX ON WHICH ALREADY AN ELEMENT PRESENT
        //THEN RIGHT SHIFT REST OF THOSE ELEMENTS IN LIST
       //myList.addAll(88, Arrays.asList(88,89,90));
        myList.forEach(list -> System.out.print(list + ", "));
        System.out.println("");
        System.out.println("ADDING ELEMENTS TO 0TH INDEX");
        myList.addAll(0, new HashSet<Integer>(Arrays.asList(11,12,13,11)));
        myList.forEach(list -> System.out.print(list + ", "));
    }
}

