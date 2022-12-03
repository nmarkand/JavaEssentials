package Collection.STREAM;

import Collection.STREAM.object.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class StreamTest {
    public static void main(String[] args) throws IOException {

        //On an array Arrays class' method used to get a stream.
        int [] myArray = {1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(myArray).sum());
        System.out.println(Arrays.stream(myArray).reduce(0, Integer::sum));
        //**********************************************************************************

        //lines() method returns streams on newBufferedReader.
        Path path = Paths.get("C:\\Users\\nilay\\Desktop\\JAVA_KAUSHIK\\README.md");
        Stream<String> lines = Files.newBufferedReader(path).lines();
        lines.forEach((line)->{
            String[] arry = line.split("price");
            String[] arry1 = arry[1].split("currency");
            System.out.println(arry1[0]);
            System.out.println(arry1[1]);
        });

        Files.lines(Paths.get("C:\\Users\\nilay\\Desktop\\JAVA_KAUSHIK\\README.md"))
                .forEach(line -> {
                    String[] arry = line.split("price");
                    String[] arry1 = arry[1].split("currency");
                    System.out.println(arry1[0]);
                    System.out.println(arry1[1]);
                });


        //lines() method returns streams on BufferedReader.
        //Stream<String> line =  new BufferedReader(new FileReader("C:\\Users\\nilay\\Desktop\\JAVA_KAUSHIK\\README.md")).lines();
       //line.forEach(System.out::println);

        //**********************************************************************************

        //All intermediary operations in a stream are lazy they do not even execute until a terminal operation hits.
        List<Integer> numList = Arrays.asList(34, 6, 3, 12);
        numList.stream().filter(n -> {
            System.out.println("While filtering - " + n);
            return n % 2==0;
        }).filter(n -> {
            System.out.println("While filtering - " + n);
            return true;
        });

        //**********************************************************************************


        int[] numbers = new Random().ints(0,1000).limit(4).toArray();
        Arrays.stream(numbers).min().ifPresent(System.out::println);

//OR
        new Random().ints(4, 0, 1000).min().ifPresent(System.out::println);

        //**********************************************************************************

        //BOXED Method is useful to collect autoboxed stream of primitives.
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        System.out.println(IntStream.of(1, 2, 3, 4, 5).boxed().reduce(0, Integer::sum));

        List<Integer> numFromBoxedList = intStream.boxed().collect(Collectors.toList());
        System.out.println(numFromBoxedList);

        System.out.println("***************************************************************************************************");

        List<List<String>> nestedList = asList(
                asList("one:one"),
                asList("two:one", "two:two", "two:three"),
                asList("three:one", "three:two", "three:three", "three:four"));

        System.out.println("BEFORE FLATMAP FLAT MAP");
        System.out.println(nestedList);

        System.out.println("AFTER FLAT MAP");
        //FLATMAP TAKES STREAM AS AN ARGUMENT
        System.out.println(nestedList.stream().flatMap(List::stream).collect(Collectors.toList()));

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        System.out.println("BEFORE FLATMAP FLAT MAP");
        Arrays.stream(array).forEach(System.out::println);

        System.out.println("AFTER FLAT MAP");
        String[] result1 = Arrays.stream(array).flatMap(Arrays::stream).toArray(String[]::new);

        Arrays.stream(result1).forEach(System.out::print);
    }
}
