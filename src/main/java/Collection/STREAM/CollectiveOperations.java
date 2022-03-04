package Collection.STREAM;

import Collection.STREAM.object.Employee;
import Collection.STREAM.object.Student;
import Collection.STREAM.object.StudentAgeComparator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectiveOperations {
    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("A", "B", "C", "D", "E", "F", "D", "E", "F");
        List<Integer> numList = Arrays.asList(34, 6, 3, 12, 98, 93, 57, 55, 66, 34, 6, 3, 2, 12);
        List<Student> studentList = Arrays.asList(
                new Student(1, "Nilay", 10, 25),
                new Student(2, "Vishakha", 11, 20),
                new Student(3, "Prakrati", 12, 15),
                new Student(4, "Nilay2", 13, 25),
                new Student(5, "Vishakha2", 14, 20),
                new Student(6, "Prakrat2", 15, 15));


        System.out.println("COUNT");
        //COUNT method on LIST/Stream
        System.out.println(stringList.stream().count());
        System.out.println(numList.stream().count());
        System.out.println(studentList.stream().count());

        //***************************************************************************************************

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

        //***************************************************************************************************

        //DISTINCT method - Returns a stream of elements which has only unique elements and no duplicates
        System.out.println("DISTINCT");
        numList.stream().distinct().forEach(System.out::println);

        System.out.println();
        stringList.stream().distinct().forEach(System.out::println);

        System.out.println();
        studentList.stream().distinct().forEach(System.out::println);
        studentList.stream().distinct().forEach(System.out::println);

        //***************************************************************************************************

        //LIMIT method - Returns elements from a list based on limit
        System.out.println("LIMIT");

        numList.stream().limit(3).forEach(System.out::println);

        System.out.println();
        stringList.stream().limit(4).forEach(System.out::println);

        System.out.println();
        studentList.stream().limit(4).forEach(System.out::println);

        //***************************************************************************************************

        //findFirst method - Returns first elements from a list
        System.out.println("FIND FIRST");

        System.out.println(numList.stream().findFirst());
        System.out.println(stringList.stream().findFirst());
        System.out.println(studentList.stream().findFirst());

        //***************************************************************************************************

        //findFirst method - Returns any elements from a list
        System.out.println("FIND ANY");

        System.out.println(numList.stream().findAny());
        System.out.println(stringList.stream().findAny());
        System.out.println(studentList.stream().findAny());

        //***************************************************************************************************

        //MAX method - Returns max elements from a list based on provided comparator
        System.out.println("MAX");

        System.out.println(numList.stream().max(Integer::compare));
        System.out.println(stringList.stream().max(String::compareTo));
        studentList.stream().max(new StudentAgeComparator()).ifPresent(s -> System.out.println(s.getName()));

        //***************************************************************************************************

        //MIN method - Returns min elements from a list based on provided comparator
        System.out.println("MIN");

        System.out.println(numList.stream().min(Integer::compare));
        System.out.println(stringList.stream().min(String::compareTo));
        studentList.stream().min(new StudentAgeComparator()).ifPresent(s -> System.out.println(s.getName()));

        //***************************************************************************************************

        //ALL MATCH method - Returns true or false if all elements of stream matches the condition
        System.out.println("ALL MATCH");

        System.out.println(numList.stream().allMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().allMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().allMatch(student -> student.getAge() < 40));

        //***************************************************************************************************

        //ANY MATCH method - Returns true or false if any of the stream elements of stream matches the condition
        System.out.println("ANY MATCH");

        System.out.println(numList.stream().anyMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().anyMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().anyMatch(student -> student.getAge() < 40));

        //***************************************************************************************************

        //NONE MATCH method - Returns true if NONE of the stream elements of matches the condition else false
        System.out.println("NONE MATCH");

        System.out.println(numList.stream().noneMatch(num -> num % 2 == 0));
        System.out.println(stringList.stream().noneMatch(str -> str.startsWith("A")));
        System.out.println(studentList.stream().noneMatch(student -> student.getAge() < 40));


        //***************************************************************************************************

        System.out.println("BOXED");
        //BOXED Method is useful to collect list from a stream of primitives.
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        List<Integer> numFromBoxedList = intStream.boxed().collect(Collectors.toList());
        System.out.println(numFromBoxedList);

        //***************************************************************************************************

        //Grouping by - Helps to group a stream based on a parameter.
        System.out.println();
        Map<Integer, List<Student>> studentGroup =  studentList.stream().collect(Collectors.groupingBy(Student::getMarks));

        studentGroup.entrySet().forEach(es -> System.out.println(es.getKey()));
        studentGroup.entrySet().forEach(es -> es.getValue().forEach(val -> System.out.println(val.getName())));

        //***************************************************************************************************

        //JOIN -  join all the list elements to get a String

        System.out.println();
        System.out.println("JOINING");

        System.out.println(stringList.stream().collect(Collectors.joining()));
        //System.out.println(numList.stream().collect(Collectors.joining()));
        //System.out.println(studentList.stream().collect(Collectors.joining()));

        //***************************************************************************************************

        System.out.println();
        System.out.println("PARTITIONED BY");
        //Partition by - By using this method a stream can be partitioned in 2 parts first those who follow partition condition
        // and second those who do not follow partition condition.

        Map<Boolean, List<Integer>> partitionedMap = numList.stream().collect(Collectors.partitioningBy(element -> element % 2 == 0));

        partitionedMap.entrySet().forEach(es -> System.out.println(es.getKey()));
        partitionedMap.entrySet().forEach(es -> es.getValue().forEach(System.out::println));

        //***************************************************************************************************
        //PEEK IS SIMILAR TO MAP BUT MAP BUT RETURNS NO VALUE (IT TAKES CONSUMER AS AN ARGUMENT, SO NO RETURN)
        //MAP IS SIMILAR TO PEEK BUT MAP RETURNS A VALUE (IT TAKES FUNCTION AS AN ARGUMENT, SO IT RETURNS)
        //***************************************************************************************************

        //SKIP - SKIPS FIRST N ELEMENTS AND RETURNS REST OF THE ELEMENTS FROM LIST
        System.out.println(numList.stream().skip(5).collect(Collectors.toList()));

        //***************************************************************************************************

        System.out.println("SORTED");
        //SORTED - To sort a list, also we can pass a comparator to sort elements
        System.out.println();
        numList.stream().sorted(Integer::compareTo).forEach(System.out::println);

        System.out.println();
        numList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println();
        studentList.stream().sorted(new StudentAgeComparator()).forEach(student -> System.out.println(student.getName()));

        //***************************************************************************************************

        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Nilay", Arrays.asList(11, 22, 33)),
                new Employee(2, "Vishakha", Arrays.asList(33, 44, 55)),
                new Employee(3, "Prakrati", Arrays.asList(22, 66, 77)));

        List<Integer> fltEmpList = employeeList.stream().flatMap(emp -> emp.getDepartmentIds().stream()).collect(Collectors.toList());

        System.out.println(fltEmpList);

        //***************************************************************************************************

        Integer [] myArray = new Integer[10];
        Integer[] myArray2 = new Integer[5];

        myArray = myArray2 ;


    }
}
