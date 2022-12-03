package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        System.out.println("ADDING ELEMENTS TO HASHMAP");
        HashMap<Integer, String> myHashMap = new HashMap<>();

        System.out.println(myHashMap.put(1, "Nilay"));
        myHashMap.put(2, "Vishakha");
        myHashMap.put(3, "Prakrati");
        myHashMap.put(4, "ABC");
        myHashMap.put(5, "DEF");
        myHashMap.put(5, "GHI");

        System.out.println("ITERATING OVER HASHMAP USING ITERATOR");
        Iterator<Integer> myHashMapIterator = myHashMap.keySet().iterator();
        while(myHashMapIterator.hasNext()) {
            System.out.println(myHashMapIterator.next());
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING KEYSET");
        for(Integer key : myHashMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING VALUES");
        for(String value : myHashMap.values()) {
            System.out.println(value);
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING ENTRYSET");
        for(Map.Entry<Integer, String> keyValue : myHashMap.entrySet()) {
            System.out.println(keyValue.getKey() + ", " + keyValue.getValue());
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING FOREACH METHOD");
        myHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("CONTAINS KEY CHECK");
        System.out.println(myHashMap.containsKey(5));
        myHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REPLACE");
        System.out.println(myHashMap.replace(6, "REPLACE"));

        System.out.println("");
        System.out.println("PUT IF ABSENT");
        System.out.println(myHashMap.putIfAbsent(6, "ADDED IT WAS NOT PRESENT"));
        myHashMap.forEach((key, value) -> System.out.println(key + ", " + value));
        System.out.println(myHashMap.putIfAbsent(6, "putIfAbsent"));

        System.out.println("");
        System.out.println(myHashMap.replace(6, "REPLACE VALUE"));
        myHashMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REMOVE");
        System.out.println(myHashMap.remove(5));
        myHashMap.forEach((key, value) -> System.out.println(key + ", " + value));
        System.out.println(myHashMap.remove(9, "GH"));

        System.out.println(myHashMap.remove(4, "ABC"));

        myHashMap.clear();
    }
}
