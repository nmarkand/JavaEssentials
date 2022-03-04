package Collection.STREAM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) throws IOException {

        //On an array Arrays class' method used to get a stream.
        int [] myArray = {1, 2, 3, 4, 5};
        //System.out.println(Arrays.stream(myArray).sum());

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

        //lines() method returns streams on BufferedReader.
        Stream<String> line =  new BufferedReader(new FileReader("C:\\Users\\nilay\\Desktop\\JAVA_KAUSHIK\\README.md")).lines();
       // line.forEach(System.out::println);

        //**********************************************************************************

        //All intermediary operations in a stream are lazy they do not even execute until a terminal operation hits.
        List<Integer> numList = Arrays.asList(34, 6, 3, 12);
        numList.stream().filter(n -> {
            //System.out.println("While filtering - " + n);
            return n % 2==0;
        });

        //**********************************************************************************


    }
}
