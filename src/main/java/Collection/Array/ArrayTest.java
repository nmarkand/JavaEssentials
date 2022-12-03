package Collection.Array;

import Collection.STREAM.object.Employee;

import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] intArr = new int[10];
        Employee[] empArray = new Employee[10];
        Arrays.stream(intArr).distinct();
        Arrays.stream(intArr).asDoubleStream();
        Arrays.stream(empArray);
    }
}
