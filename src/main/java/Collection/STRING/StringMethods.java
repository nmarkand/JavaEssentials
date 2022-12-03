package Collection.STRING;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

        //CHARAT
        String str1 = "MyNameIsNilay";
        char c = str1.charAt(5);

        System.out.println(c);

        //**********************************************************************************

        //GET CHARS - Does not return anything but fills a character array with specified start and end characters of a string.
        String str2 = "MyNameIsNilay";
        int start = 2;
        int end = 6;
        char [] charArray = new char[end + 1 - start];
        System.out.println(charArray);
        str2.getChars(start, end, charArray, 0);
        System.out.println(charArray);

        //**********************************************************************************

        //TO CHARARRAY
        String str3 = "MyNameIsNilay";
        char [] myCharArray = str3.toCharArray();
        System.out.println(myCharArray);

        //**********************************************************************************

        //EQUALS AND EQUALS IGNORE CASE
        String str4 = "MyNameIsNilay";
        String str5 = "MyNameIsNilay";
        String str6 = "mynameisNilay";
        String str7 = new String("MyNameIsNilay");

        System.out.println(str4.equals(str5));
        System.out.println(str4 == str5);

        System.out.println(str4.equals(str7));
        System.out.println(str4 == str7);

        System.out.println(str5.equalsIgnoreCase(str6));
        System.out.println(str5.equalsIgnoreCase(str7));

        //It is important to understand that the equals( ) method and the == operator perform two
        //different operations. As just explained, the equals( ) method compares the characters
        //inside a String object. The == operator compares two object references to see whether they
        //refer to the same instance.
        //**********************************************************************************

        //REGION MATCH
        //startIndex specifies the index at which the region begins within the
        //invoking String object. The String being compared is specified by str2. The index at which
        //the comparison will start within str2 is specified by str2StartIndex. The length of the substring
        //being compared is passed in numChars. In the second version, if ignoreCase is true, the case
        //of the characters is ignored. Otherwise, case is significant.
        String str8 = "MyNameIsNilay";
        String str9 = new String("MyNameIsNilay");
        String str10 = "mynameisNilay";

        System.out.println(str8.regionMatches(false, 0, str10, 0, 5));
        System.out.println(str8.regionMatches(true, 0, str10, 0, 5));

        System.out.println(str8.regionMatches(false, 3, str9, 3, 5));
        System.out.println(str8.regionMatches(true, 3, str9, 3, 5));

        //**********************************************************************************

        //STARTSWITH
        //ENDSWITH

        System.out.println("Foobar".endsWith("bar"));
        System.out.println("Foobar".startsWith("Foo"));

        //**********************************************************************************

        //compareTo( )

        //it is not enough to simply know whether two strings are identical. For sorting
        //applications, you need to know which is less than, equal to, or greater than the next. A string
        //is less than another if it comes before the other in dictionary order. A string is greater than
        //another if it comes after the other in dictionary order. The method compareTo( ) serves
        //this purpose. It is specified by the Comparable<T> interface, which String implements.

        //Less than zero - The invoking string is less than str (comes before in directory).
        //Greater than zero - The invoking string is greater than str (comes after in directory).
        //Zero - The two strings are equal.

        System.out.println("Ghanshyam".compareTo("Ghanshyam"));
        System.out.println("Ghanshyam".compareTo("Ghan"));
        System.out.println("Ghanshyam".compareTo("shyam"));

        System.out.println("Ghanshyam".compareTo("GHANSHYAM"));
        System.out.println("Ghanshyam".compareTo("GHAN"));
        System.out.println("Ghanshyam".compareTo("SHYAM"));

        //**********************************************************************************

        //String class provides two methods that allow you to search a string for a specified
        //character or substring:
        //• indexOf( ) Searches for the first occurrence of a character or substring.
        //• lastIndexOf( ) Searches for the last occurrence of a character or substring.

        System.out.println("Markanday".indexOf("a"));
        System.out.println("Markanday".indexOf("ar"));
        System.out.println("Markanday".indexOf("A"));
        System.out.println("Markanday".indexOf("aR"));

        System.out.println("Markanday".lastIndexOf("a"));
        System.out.println("Markanday".lastIndexOf("ar"));
        System.out.println("Markanday".lastIndexOf("A"));
        System.out.println("Markanday".lastIndexOf("Ar"));

        //**********************************************************************************

        //SUBSTRING

        //Because String objects are immutable, whenever you want to modify a String, you must
        //either copy it into a StringBuffer or StringBuilder, or use a String method that constructs a
        //new copy of the string with your modifications complete.
        //All String methods who modify a string always returns a new string

        System.out.println("markanday".substring(2));
        System.out.println("markanday".substring(2, 5));

        //**********************************************************************************

        //CONCAT

        System.out.println("Nilay".concat("Markanday"));

        //**********************************************************************************

        //REPLACE

        System.out.println("Nilay".replace("a", "Ma"));
        System.out.println("Nilay".replace("lay", "Ma"));

        //**********************************************************************************

        //trim( )
        //The trim( ) method returns a copy of the invoking string from which any leading and
        //trailing whitespace has been removed.

        String str11 = " Nilay ";
        System.out.println(str11.length());
        System.out.println(str11.trim().length());

        //**********************************************************************************

        // valueOf( ) is called when a string representation of some other
        // type of data is needed—for example, during concatenation operations example "Total:" 2 + 4 .
        // Because Now Java will covert 2 and 4 integers to String as one of the operand of concatenation is String and hence
        // value of method is called to get String value of 2 and 4 integers, which internally calls toString() method
        // You can call this method directly with any data type and get a reasonable String representation. All of the
        // simple types are converted to their common String representation. Any object that you pass
        // to valueOf( ) will return the result of a call to the object’s toString( ) method. In fact, you
        // could just call toString( ) directly and get the same result.

        System.out.println("Total is :" + 2+2);

        //**********************************************************************************

        System.out.println("markanday".toUpperCase());
        System.out.println("markanday".toLowerCase());

        //**********************************************************************************

        //JDK 8 adds a new method to String called join( ). It is used to concatenate two or more
        //strings, separating each string with a delimiter, such as a space or a comma.

        //static String join(CharSequence delim, CharSequence . . . strs)

        //Here, delim specifies the delimiter used to separate the character sequences specified by strs.
        //Because String implements the CharSequence interface, strs can be a list of strings.

        System.out.println(String.join(" ", "Alpha", "Beta", "Gamma"));
        System.out.println(String.join(" ~ ", "Alpha", "Beta", "Gamma"));

        //**********************************************************************************

        //boolean matches(string regExp) -- returns string which matches regular expression
        //String[ ] split(String regExp) -- returns String array in which strings are split based on expression or another string.

        String [] splitString =  "Alpha, Beta, Gama".split(", ");
        System.out.println(splitString.length);

        Arrays.stream(splitString).forEach(str -> System.out.println(str +" "+str.length()));

        //**********************************************************************************
    }
}
