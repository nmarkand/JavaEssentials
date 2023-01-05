package Java12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java12Features {
    public static void main(String[] args) throws IOException {
        stringMethods();
        fileMethods();
        collectorMethods();
        numberFormat();
    }

    public static void stringMethods() {
        //Indent method - brings spaces before a string
            // If the parameter is greater than zero, new spaces will be inserted at the beginning of each line.
            // On the other hand, if the parameter is less than zero, it removes spaces from the begging of each line.

        System.out.println("Indent method");
        String text = "Hello Baeldung!\nThis is Java 12 article.";

        text = text.indent(4);
        System.out.println(text);

        text = text.indent(-10);
        System.out.println(text);

        System.out.println("****************************************************************************************");


        System.out.println("Transform method");
        //Transform method - It accepts a single argument function as a parameter that will be applied to the string.
        text = "Baeldung";
        String transformed = text.transform(value ->
                new StringBuilder(value).reverse().toString()
        );

        System.out.println(transformed);

        System.out.println("****************************************************************************************");
    }

    public static void fileMethods() throws IOException {

        System.out.println("Mismatch method");
        //Mismatch method - The method is used to compare two files and find the position of the first mismatched byte in their contents.
        // Outputs -
            // -1L if the files are identical.
            //  position of mismatched byte if file content are not same

        //Create two .txt files
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");

        //fill text content in the file
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        //Apply mismatch method
        long mismatch = Files.mismatch(filePath1, filePath2);

        System.out.println(mismatch);

        //fill text content in the file
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Tutorial");

        //Apply mismatch method
        mismatch = Files.mismatch(filePath1, filePath2);

        System.out.println(mismatch);
    }

    public static void collectorMethods() {
        System.out.println("Teeing method");
        // It is a composite of two downstream collectors. Every element is processed by both downstream collectors.
        // Then their results are passed to the merge function and transformed into the final result.

        // The example usage of teeing collector is counting an average from a set of numbers.
        // The first collector parameter will sum up the values, and the second one will give us the count of all numbers.
        // The merge function will take these results and count the average:

        long mean = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.teeing(Collectors.summingInt(i -> i),
                        Collectors.counting(), (sum, count) -> sum / count));

        System.out.println(mean);

        long sum = Stream.of("ABC", "BCD", "CDE", "DEF")
                .collect(Collectors.teeing(Collectors.counting(), Collectors.counting(), Long::sum));

        System.out.println(sum);
    }

    public static void numberFormat() {
        System.out.println("Format method - NumberFormat");
        //number formatter – the CompactNumberFormat. It's designed to represent a number in a shorter form,
        // based on the patterns provided by a given locale.

        NumberFormat defaultFormat =
                NumberFormat.getCompactNumberInstance();
        defaultFormat.setMaximumFractionDigits(2);
        System.out.println(defaultFormat.format(2592));

        NumberFormat likesShort =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        likesShort.setMaximumFractionDigits(2);
        System.out.println(likesShort.format(2592));

        NumberFormat likesLong =
                NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        likesLong.setMaximumFractionDigits(2);
        System.out.println(likesLong.format(2592));
    }

    // The Class data sharing (CDS) feature helps reduce the startup time and memory footprint between multiple
    // Java Virtual Machines (JVM).

    // Starting from JDK 12, a default CDS archive is pre-packaged with the Oracle JDK binary.
    // The default CDS archive is created at the JDK build time by running -Xshare:dump, using G1 GC and 128M Java heap.
    // It uses a built-time generated default class list that contains the selected core library classes.
    // The default CDS archive resides in the following location:
    // On Linux and macOS platforms, the shared archive is stored in /lib/[arch]/server/classes.jsa

    // When the JVM starts, the shared archive is memory-mapped to allow sharing of read-only JVM metadata for these
    // classes among multiple JVM processes. Because accessing the shared archive is faster than loading the classes,
    // startup time is reduced. Class data sharing is supported with the ZGC, G1, serial, and parallel garbage collectors.

    // The primary motivation for including CDS in Java SE is to decrease in startup time. The smaller the application relative
    // to the number of core classes it uses, the larger the saved fraction of startup time.

    // The footprint cost of new JVM instances has been reduced in two ways:
    // A portion of the shared archive on the same host is mapped as read-only and shared among multiple JVM processes.
    // Otherwise, this data would need to be replicated in each JVM instance, which would increase the startup time of application.
    //
    // The shared archive contains class data in the form that the JVM uses it.
    // The memory that would otherwise be required to access the original class information in the runtime modular image,
    // is not used. These memory savings allow more applications to be run concurrently on the same system.

    //Application Class-Data Sharing
    //To further reduce the startup time and the memory footprint, Application Class-Data Sharing (AppCDS) is introduced that
    // extends the CDS to include selected classes from the application class path.

    //
    //This feature allows application classes to be placed in a shared drive. The common class metadata is shared across
    // different Java processes. AppCDS allows the built-in system class loader, built-in platform class loader, and custom
    // class loaders to load the archived classes. When multiple JVMs share the same archive file, memory is saved and
    // the overall system response time improves.

}
