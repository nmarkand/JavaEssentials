package Collection.STRING;

public class StringBufferTest {

    public static void main(String[] args) {
        //StringBuffer supports a modifiable string. As you know, String represents fixed-length,
        //immutable character sequences. In contrast, StringBuffer represents growable and writable
        //character sequences. StringBuffer may have characters and substrings inserted in the
        //middle or appended to the end. StringBuffer will automatically grow to make room for
        //such additions and often has more characters preallocated than are actually needed, to
        //allow room for growth.

        StringBuffer sb1 = new StringBuffer("Nilay");

        System.out.println(sb1);
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());

        //**********************************************************************************

        //SET LENGTH
        StringBuffer sb2 = new StringBuffer("Nilay");
        sb2.setLength(2);

        System.out.println(sb2);
        System.out.println(sb2.length());
        System.out.println(sb2.capacity());

        //**********************************************************************************

        //INSERT METHOD

        StringBuffer sb3 = new StringBuffer("I Java");
        sb3.insert(2, "like ");

        System.out.println(sb3);

        //**********************************************************************************
        //REVERSE
        StringBuffer sb4 = new StringBuffer("oh oh oh");
        sb4.reverse();

        System.out.println(sb4);

        //**********************************************************************************

        //DELETE - You can delete characters within a StringBuffer by using the methods
        // delete( ) and deleteCharAt( ).

        System.out.println(new StringBuffer("This is Java").delete(4, 7));

        System.out.println(new StringBuffer("This is Java").deleteCharAt(8));

        //**********************************************************************************
        //REPLACE

        System.out.println(new StringBuffer("This is Java 5").replace(5, 7, "was"));
    }
}


