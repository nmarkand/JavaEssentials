package Collection.STREAM;

import Collection.STREAM.object.Employee;
import Collection.STREAM.object.Student;
import Collection.STREAM.object.StudentAgeComparator;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class CollectiveOperations {
    public static void main(String[] args) {

        List<String> stringList = asList("A", "B", "C", "D", "E", "F", "D", "E", "F");
        List<Integer> numList = asList(34, 6, 3, 12, 98, 93, 57, 55, 66, 34, 6, 3, 2, 12);
        List<Student> studentList = asList(
                new Student(1, "Nilay", 10, 25),
                new Student(2, "Vishakha", 11, 20),
                new Student(3, "Prakrati", 12, 15),
                new Student(4, "Nilay2", 10, 25),
                new Student(5, "Vishakha2", 12, 20),
                new Student(6, "Prakrat2", 15, 10));


        System.out.println("COUNT");
        //COUNT method on LIST/Stream
        System.out.println(stringList.stream().count());
        System.out.println(numList.stream().count());
        System.out.println(studentList.stream().count());

        System.out.println("***************************************************************************************************");

        // CONCAT used to concat two streams
        // whose elements are all the elements of the first stream followed by all the elements of the second stream
        System.out.println("CONCAT");
        Stream.concat(stringList.stream(), numList.stream()).forEach(System.out::print);

        System.out.println();
        Stream.concat(stringList.stream(), stringList.stream()).forEach(System.out::print);

        System.out.println();
        Stream.concat(stringList.stream(), studentList.stream()).forEach(System.out::print);

        System.out.println();
        Stream.concat(numList.stream(), numList.stream()).forEach(System.out::print);

        System.out.println();
        System.out.println(Stream.concat(stringList.stream(), stringList.stream()).count());

        System.out.println();
        System.out.println(Stream.concat(numList.stream(), numList.stream()).count()); //Real count of numbers

        System.out.println("***************************************************************************************************");

        //DISTINCT method - Returns a stream of distinct elements and no duplicates
        System.out.println("DISTINCT");
        numList.stream().distinct().forEach(System.out::println);

        System.out.println();
        stringList.stream().distinct().forEach(System.out::println);

        System.out.println();
        studentList.stream().distinct().forEach(System.out::println);
        studentList.stream().distinct().forEach(System.out::println);

        System.out.println("***************************************************************************************************");

        //LIMIT method - Returns number of elements from a list as per set limit
        System.out.println("LIMIT");

        numList.stream().limit(3).forEach(System.out::println);

        System.out.println();
        stringList.stream().limit(4).forEach(System.out::println);

        System.out.println();
        studentList.stream().limit(4).forEach(System.out::println);

        System.out.println("***************************************************************************************************");

        //findFirst method - Returns first elements from a list
        System.out.println("FIND FIRST");

        System.out.println(numList.stream().findFirst());
        stringList.stream().findFirst().ifPresent(System.out::println);
        System.out.println(studentList.stream().findFirst().isPresent());

        System.out.println("***************************************************************************************************");

        //findAny method - Returns any elements from a list
        System.out.println("FIND ANY");

        System.out.println(numList.stream().findAny());
        stringList.stream().findAny().ifPresent(System.out::println);
        System.out.println(studentList.stream().findAny());

        System.out.println("***************************************************************************************************");

       //MAX method - Returns max elements from a list based on provided comparator
        System.out.println("MAX");

        System.out.println(numList.stream().max(Integer::compare));
        System.out.println(stringList.stream().max(String::compareTo));
        studentList.stream().max(new StudentAgeComparator()).ifPresent(s -> System.out.println(s.getName()));

        System.out.println("***************************************************************************************************");

        //MIN method - Returns min elements from a list based on provided comparator
        System.out.println("MIN");

        System.out.println(numList.stream().min(Integer::compare));
        System.out.println(stringList.stream().min(String::compareTo));
        studentList.stream().min(new StudentAgeComparator()).ifPresent(s -> System.out.println(s.getName()));

        System.out.println("***************************************************************************************************");

        //ALL MATCH method - Returns true or false if all elements of stream matches the condition
        System.out.println("ALL MATCH");

        System.out.println(numList.stream().allMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().allMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().allMatch(student -> student.getAge() < 40));

        System.out.println("***************************************************************************************************");

        //ANY MATCH method - Returns true or false if any of the stream elements of stream matches the condition
        System.out.println("ANY MATCH");

        System.out.println(numList.stream().anyMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().anyMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().anyMatch(student -> student.getAge() < 40));

        System.out.println("***************************************************************************************************");

        //NONE MATCH method - Returns true if NONE of the stream elements of matches the condition else false
        System.out.println("NONE MATCH");

        System.out.println(numList.stream().noneMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().noneMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().noneMatch(student -> student.getAge() < 40));


        System.out.println("***************************************************************************************************");

        System.out.println("BOXED");
        //BOXED Method is useful to collect autoboxed stream of primitives.
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList()));
        System.out.println(IntStream.of(1, 2, 3, 4, 5).reduce(0, Integer::sum));
        List<Integer> numFromBoxedList = intStream.boxed().collect(Collectors.toList());
        System.out.println(numFromBoxedList);

        System.out.println("***************************************************************************************************");

        System.out.println("GROUPING BY");
        //groupingBy - Helps to group a stream based on a parameter.
        Map<Integer, List<Student>> studentGroupByMarks =  studentList.stream().collect(Collectors.groupingBy(Student::getMarks));

        studentGroupByMarks.forEach((key, value) -> System.out.println( key + " " + value));
        studentGroupByMarks.forEach((key, value) -> value.forEach(val -> System.out.println(val.getName())));

        Map<Integer, List<Student>> studentGroupByAge =  studentList.stream().collect(Collectors.groupingBy(Student::getAge));
        studentGroupByAge.forEach((key, value) -> System.out.println( key + " " + value));
        studentGroupByAge.forEach((key, value) -> value.forEach(val -> System.out.println(val.getName())));

        Map<Object, List<Integer>> intNewGroup = numList.stream().collect(Collectors.groupingBy(integer -> integer > 34));
        intNewGroup.forEach((key, value) -> System.out.println( key + " " + value));

        System.out.println("GROUPING BY COUNTING");
        Map<Integer, Long> studentCount = studentList.stream().collect(Collectors.groupingBy(Student::getMarks, Collectors.counting()));

        System.out.println("***************************************************************************************************");

        //joining -  join all the list elements to get a String

        System.out.println();
        System.out.println("JOINING");

        System.out.println(stringList.stream().collect(Collectors.joining()));

        //It won't work with numbers and objects
        //System.out.println(numList.stream().collect(Collectors.joining()));
        //System.out.println(studentList.stream().collect(Collectors.joining()));

        System.out.println("***************************************************************************************************");

        System.out.println("PARTITIONING BY");
        //partitioningBy - By using this method a stream can be partitioned in 2 parts first those who follow partition condition
        // and second those who do not follow partition condition.

        Map<Boolean, List<Integer>> partitionedMap = numList.stream().collect(Collectors.partitioningBy(element -> element % 2 == 0));

        partitionedMap.forEach((key, value) -> System.out.println(key));
        partitionedMap.forEach((key, value) -> value.forEach(System.out::println));

        Map<Boolean, List<Student>> studentPartitionedBy = studentList.stream().collect(Collectors.partitioningBy(student -> student.getName().startsWith("N")));
        studentPartitionedBy.get(true).forEach(student -> System.out.println(student.getName()));
        studentPartitionedBy.get(false).forEach(student -> System.out.println(student.getName()));
        //***************************************************************************************************
        //PEEK IS SIMILAR TO MAP BUT MAP BUT RETURNS NO VALUE (IT TAKES CONSUMER AS AN ARGUMENT, SO NO RETURN)
        //MAP IS SIMILAR TO PEEK BUT MAP RETURNS A VALUE (IT TAKES FUNCTION AS AN ARGUMENT, SO IT RETURNS)

        System.out.println("***************************************************************************************************");

        //SKIP - SKIPS FIRST N ELEMENTS AND RETURNS REST OF THE ELEMENTS FROM LIST
        System.out.println(numList.stream().skip(5).collect(Collectors.toList()));

        System.out.println("***************************************************************************************************");

        System.out.println("SORTED");
        //SORTED - To sort a list, also we can pass a comparator to sort elements
        System.out.println("COMPARABLE COMPARE TO");
        numList.stream().sorted(Integer::compareTo).forEach(System.out::println);

        System.out.println("COMPARATOR REVERSE ORDER");
        numList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("DEFAULT SORT");
        numList.stream().sorted().forEach(System.out::println);

        System.out.println("STUDENT AGE COMPARATOR");
        studentList.stream().sorted(new StudentAgeComparator()).forEach(student -> System.out.println(student.getName()));

        System.out.println("***************************************************************************************************");

        List<List<String>> nestedList = asList(
                asList("one:one"),
                asList("two:one", "two:two", "two:three"),
                asList("three:one", "three:two", "three:three", "three:four"));

        System.out.println("BEFORE FLATMAP FLAT MAP");
        System.out.println(nestedList);

        System.out.println("AFTER FLAT MAP");
        //FLATMAP TAKES STREAM AS AN ARGUMENT
        System.out.println(nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        // Java 8
        String[] result = Stream.of(array)  // Stream<String[]>
                .flatMap(Stream::of)        // Stream<String>
                .toArray(String[]::new);    // [a, b, c, d, e, f]

        Arrays.stream(result).forEach(System.out::print);

        //***************************************************************************************************

       /* Integer [] myArray = new Integer[10];
        Integer[] myArray2 = new Integer[5];

        myArray = myArray2 ;*/

    }
}
