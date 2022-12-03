package Collection.Map;

import Collection.STREAM.object.StudentAgeComparator;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        System.out.println("ADDING ELEMENTS TO TREEMAP");
        TreeMap<Integer, String> myTreeMap = new TreeMap<>();

        myTreeMap.put(5, "DEF");
        myTreeMap.put(9, "GHI");
        myTreeMap.put(1, "Nilay");
        myTreeMap.put(2, "Vishakha");
        myTreeMap.put(3, "Prakrati");
        myTreeMap.put(4, "ABC");
        myTreeMap.put(5, "JKL");

        System.out.println("HEADMAP IN TREEMAP");
        System.out.println(myTreeMap.headMap(3));

        System.out.println("TAILMAP IN TREEMAP");
        System.out.println(myTreeMap.tailMap(3));

        System.out.println("SUBMAP FROM ONE KEY TO ANOTHER KEY IN TREEMAP");
        System.out.println(myTreeMap.subMap(2,4));

        System.out.println("ITERATING OVER HASHMAP USING ITERATOR");
        Iterator<Integer> myHashMapIterator = myTreeMap.keySet().iterator();
        while(myHashMapIterator.hasNext()) {
            System.out.println(myHashMapIterator.next());
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING KEYSET");
        for(Integer key : myTreeMap.keySet()) {
            System.out.println(key);
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING VALUES");
        for(String value : myTreeMap.values()) {
            System.out.println(value);
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING ENTRYSET NORMAL ORDER/ASCENDING");
        for(Map.Entry<Integer, String> keyValue : myTreeMap.entrySet()) {
            System.out.println(keyValue.getKey() + ", " + keyValue.getValue());
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING ENTRYSET DESCENDING ORDER");
        for(Map.Entry<Integer, String> keyValue : myTreeMap.descendingMap().entrySet()) {
            System.out.println(keyValue.getKey() + ", " + keyValue.getValue());
        }

        System.out.println("");
        System.out.println("ITERATING OVER HASHMAP USING FOREACH METHOD");
        myTreeMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("CONTAINS KEY CHECK");
        System.out.println(myTreeMap.containsKey(5));
        myTreeMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REPLACE");
        System.out.println(myTreeMap.replace(6, "REPLACE"));

        System.out.println("");
        System.out.println("PUT IF ABSENT");
        System.out.println(myTreeMap.putIfAbsent(6, "ADDED IT WAS NOT PRESENT"));
        myTreeMap.forEach((key, value) -> System.out.println(key + ", " + value));
        System.out.println(myTreeMap.putIfAbsent(6, "putIfAbsent"));

        System.out.println("");
        System.out.println(myTreeMap.replace(6, "REPLACE VALUE"));
        myTreeMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println("");
        System.out.println("REMOVE");
        System.out.println(myTreeMap.remove(5));
        myTreeMap.forEach((key, value) -> System.out.println(key + ", " + value));

        System.out.println(myTreeMap.remove(9, "GH"));

        System.out.println(myTreeMap.remove(9, "GHI"));
        myTreeMap.clear();
    }
}
