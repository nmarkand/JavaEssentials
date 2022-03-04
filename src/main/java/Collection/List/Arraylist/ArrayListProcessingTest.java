package Collection.List.Arraylist;

import java.util.*;

public class ArrayListProcessingTest {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.addAll(Arrays.asList(98,97,96,95,94,93,92,91,90,89,88));
        myList.forEach(list -> System.out.print(list + ", ") );

        //Iterator iterates over a list.
        System.out.println("");
        System.out.println("ITERATOR");
        Iterator<Integer> iterator =  myList.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }

        //ListIterator iterates over a list, provides more functions.
        System.out.println("");
        System.out.println("LIST ITERATOR");
        Iterator<Integer> listIterator =  myList.listIterator();
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next() + ", ");
        }

        //ListIterator from an index.
        System.out.println("");
        System.out.println("LIST ITERATOR");
        Iterator<Integer> listIteratorFromIndex =  myList.listIterator(2);
        while(listIteratorFromIndex.hasNext()) {
            System.out.print(listIteratorFromIndex.next() + ", ");
        }
    }
}

