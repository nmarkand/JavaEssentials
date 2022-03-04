package Collection.Set;

import java.util.*;

public class LinkedHashSetTest {
    public static void main(String[] args) {

        LinkedHashSet<Integer> myLinkedHashSet = new LinkedHashSet<>();

        System.out.println("ADDED ELEMENTS TO LINKED HASHSET");
        myLinkedHashSet.add(11);
        myLinkedHashSet.addAll(Arrays.asList(12,13,14,14,15,16,17,18,19,20));

        myLinkedHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("CHECK ELEMENTS IN LINKED HASHSET USING CONTAINS");
        System.out.println(myLinkedHashSet.contains(13));
        System.out.println(myLinkedHashSet.containsAll(Arrays.asList(12,13,888)));

        System.out.println("REMOVING ELEMENTS FROM LINKED HASHSET");
        System.out.println(myLinkedHashSet.remove(13));
        System.out.println(myLinkedHashSet.removeAll(Arrays.asList(12,13,888)));

        System.out.println("RETAIN ELEMENTS IN LINKED HASHSET");
        myLinkedHashSet.retainAll(new HashSet<>(Arrays.asList(14,15,16,17,18,19)));
        myLinkedHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("REMOVING IF FROM LINKED HASHSET");
        myLinkedHashSet.removeIf(element -> element % 2==0);
        myLinkedHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("ITERATING OVER A LINKED HASHSET");
        Iterator<Integer> iterator = myLinkedHashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        myLinkedHashSet.clear();
    }
}
