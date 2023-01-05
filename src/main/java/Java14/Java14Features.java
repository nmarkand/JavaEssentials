package Java14;

public class Java14Features {
    public static void main(String[] args) {
        //switchStatement("monday");
        switchStatement("FRIDAY");
        patternMatchingInstanceOf(new Object());

        Employee employee = new Employee(1L, "Nilay", "Mark", "Email", 33);

        System.out.println(employee.firstName());
        System.out.println(employee.lastName());
        System.out.println(employee.age());

        // Detailed NullPointerException message to understand error
        detailedNullPointerExceptionMessage();

        // Packaging Tool
        // Traditionally, to deliver Java code, an application developer would simply send out a JAR file that the user was
        // supposed to run inside their own JVM.
        // However, users rather expected an installer that they'd double click to install the package on their native platforms,
        // such as Windows or macOS.
        // This JEP aims to do precisely that. Developers can use jlink to condense the JDK down to the minimum required
        // modules, and then use this packaging tool to create a lightweight image that can be installed as an exe on Windows
        // or a dmg on a macOS.

        //$ jlink --add-modules java.base,java.sql --output myjre
        //$ jpackage --name myapp --input lib --main-jar main.jar --runtime-image myjre
    }


    //Records were introduced to reduce repetitive boilerplate code in data model POJOs. They simplify day to day development,
    // improve efficiency and greatly minimize the risk of human error.
    //If we want we can create customize constructors inside a record.

    public record Employee(Long id, String firstName, String lastName, String email, int age) {
    };

    public static void switchStatement(String day) {
        //Default must be a lambda expression
        //There is no need of break statement
        //There is no fallback, i.e. if condition matches switch returns back

        boolean isTodayHoliday = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY" -> false;
            case "SATURDAY", "SUNDAY" -> true;
            default -> throw new RuntimeException();
        };

        System.out.println(isTodayHoliday);
    }

    public static void patternMatchingInstanceOf(Object obj) {
        //JDK 14 has introduced pattern matching for instanceof with the aim of eliminating boilerplate code and make
        // the developer's life a little easy.

        //Before java 14 it was like
        if (obj instanceof String) {
            String str = (String) obj;
            int len = str.length();
            System.out.println(len);
        }

        //Now it is
        if (obj instanceof String str) {
            int len = str.length();
            System.out.println(len);
        }
    }

    public static void detailedNullPointerExceptionMessage() {
        // a detailed null pointer exception message computation is only done when the JVM itself throws a NullPointerException
        // — the computation won't be performed if we explicitly throw the exception in our Java code. The reason behind this is,
        // in these situations, most probably we already pass a meaningful message in the exception constructor.

        Employee employee = null;
        System.out.println(employee.age());
    }
}
