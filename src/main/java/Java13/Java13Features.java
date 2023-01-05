package Java13;

public class Java13Features {
    public static void main(String[] args) {
        System.out.println("Garbage collector");

        //Starting with Java 13, the ZGC now returns uncommitted memory to the operating system
        // by default, up until the specified minimum heap size is reached

    }

    public static void stringTextBlock() {
        //String TEXT_BLOCK_JSON = """{ "name" : "Baeldung", "website" : "https://www.%s.com/"}""";
    }

//Class data sharing (CDS) has been a prominent feature of Java HotSpot VM for a while now.
// It allows class metadata to be shared across different JVMs to reduce startup time and memory footprint.
// JDK 10 extended this ability by adding application CDS (AppCDS) – to give developers the power to include application classes
// in the shared archive. JDK 12 further enhanced this feature to include CDS archives by default.
//However, the process of archiving application classes was tedious. To generate archive files, developers had to do trial
// runs of their applications to create a class list first, and then dump it into an archive. After that, this archive could
// be used to share metadata between JVMs.
//
//With dynamic archiving, JDK 13 has simplified this process. Now we can generate a shared archive at the time the application
// is exiting. This has eliminated the need for trial runs.
//
//To enable applications to create a dynamic shared archive on top of the default system archive,
// we need to add an option -XX:ArchiveClassesAtExit and specify the archive name as argument:
//
//java -XX:ArchiveClassesAtExit=<archive filename> -cp <app jar> AppName
//Copy
//We can then use the newly created archive to run the same app with -XX:SharedArchiveFile option:
//
//java -XX:SharedArchiveFile=<archive filename> -cp <app jar> AppName
}
