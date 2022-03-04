package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        System.out.println("ADDING ELEMENTS TO LINKED HASHMAP");
        LinkedHashMap<Integer, String> myLinkedHashMap = new LinkedHashMap<>();

        myLinkedHashMap.put(5, "DEF");
        myLinkedHashMap.put(9, "GHI");
        myLinkedHashMap.put(1, "Nilay");
        myLinkedHashMap.put(2, "Vishakha");
        myLinkedHashMap.put(3, "Prakrati");
        myLinkedHashMap.put(4, "ABC");
        myLinkedHashMap.put(5, "JKL");

        System.out.println("ITERATING OVER LINKED HASHMAP USING ITERATOR");
        Iterator<Integer> myHashMapIterator = myLinkedHashMap.keySet().iterator();
        while(myHashMapIterator.hasNext()) {
            System.out.println(myHashMapIterator.next());
        }

        System.out.println("");
        System.out.println("ITERATING OVER LINKED HASHMAP USING KEYSET");
        for(Integer key : myLinkedHashMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("");
        System.out.println("ITERATING OVER LINKED HASHMAP USING VALUES");
        for(String value : myLinkedHashMap.values()) {
            System.out.println(value);
        }

        System.out.println("");
        System.out.println("ITERATING OVER LINKED HASHMAP USING ENTRYSET");
        for(Map.Entry<Integer, String> keyValue : myLinkedHashMap.entrySet()) {
            System.out.println(keyValue.getKey() + ", " + keyValue.getValue());
        }

        System.out.println("");
        System.out.println("ITERATING OVER LINKED HASHMAP USING FOREACH METHOD");
        myLinkedHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("CONTAINS KEY CHECK");
        System.out.println(myLinkedHashMap.containsKey(5));
        myLinkedHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REPLACE");
        System.out.println(myLinkedHashMap.replace(6, "REPLACE"));

        System.out.println("");
        System.out.println("PUT IF ABSENT");
        System.out.println(myLinkedHashMap.putIfAbsent(6, "ADDED IT WAS NOT PRESENT"));
        myLinkedHashMap.forEach((key, value) -> System.out.println(key + ", " + value));
        System.out.println(myLinkedHashMap.putIfAbsent(6, "putIfAbsent"));

        System.out.println("");
        System.out.println(myLinkedHashMap.replace(6, "REPLACE VALUE"));
        myLinkedHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REMOVE");
        System.out.println(myLinkedHashMap.remove(5));
        myLinkedHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println(myLinkedHashMap.remove(9, "GH"));

        System.out.println(myLinkedHashMap.remove(9, "GHI"));

        myLinkedHashMap.clear();
    }
}
