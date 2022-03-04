package Collection.Set;

import java.util.*;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> myTreeSet = new TreeSet<>();

        System.out.println("ADDED ELEMENTS TO TREE SET");
        myTreeSet.add(11);
        myTreeSet.addAll(Arrays.asList(14,15,16,17,18,19,20,12,13,14,9,8));

        myTreeSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("CHECK ELEMENTS IN TREE SET USING CONTAINS");
        System.out.println(myTreeSet.contains(13));
        System.out.println(myTreeSet.containsAll(Arrays.asList(12,13,888)));

        System.out.println("REMOVING ELEMENTS FROM TREE SET");
        System.out.println(myTreeSet.remove(13));
        System.out.println(myTreeSet.removeAll(Arrays.asList(12,13,888)));

        System.out.println("RETAIN ELEMENTS IN TREE SET");
        myTreeSet.retainAll(new HashSet<>(Arrays.asList(14,15,16,17,18,19)));
        myTreeSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("REMOVING IF FROM TREE SET");
        myTreeSet.removeIf(element -> element % 2==0);
        myTreeSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("ITERATING OVER A TREE SET");
        Iterator<Integer> iterator = myTreeSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("HEAD SET TREE SET");
        System.out.println(myTreeSet.headSet(17));

        System.out.println("TAIL SET TREE SET");
        System.out.println(myTreeSet.tailSet(15));

        System.out.println("SUB SET FROM ONE VALUE TO ANOTHER VALUE IN TREE SET");
        System.out.println(myTreeSet.subSet(15, 21)); //21st element is not present in set

        System.out.println("DESCENDING SET FROM TREE SET");
        System.out.println(myTreeSet.descendingSet());

        myTreeSet.clear();
    }
}
