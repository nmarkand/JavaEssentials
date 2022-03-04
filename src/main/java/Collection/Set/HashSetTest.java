package Collection.Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet<Integer> myHashSet = new HashSet<>();

        System.out.println("ADDED ELEMENTS TO HASHSET");
        myHashSet.add(11);
        myHashSet.addAll(Arrays.asList(12,13,14,14,15,16,17,18,19,20));

        myHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("CHECK ELEMENTS IN HASHSET USING CONTAINS");
        System.out.println(myHashSet.contains(13));
        System.out.println(myHashSet.containsAll(Arrays.asList(12,13,888)));

        System.out.println("REMOVING ELEMENTS FROM HASHSET");
        System.out.println(myHashSet.remove(13));
        System.out.println(myHashSet.removeAll(Arrays.asList(12,13,888)));

        System.out.println("RETAIN ELEMENTS IN HASHSET");
        myHashSet.retainAll(new HashSet<>(Arrays.asList(14,15,16,17,18,19)));
        myHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("REMOVING IF FROM HASHSET");
        myHashSet.removeIf(element -> element % 2 == 0);
        myHashSet.forEach(item -> System.out.print(item + ", ") );

        System.out.println("");
        System.out.println("ITERATING OVER A HASHSET");
        Iterator<Integer> iterator = myHashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        myHashSet.clear();
    }
}
