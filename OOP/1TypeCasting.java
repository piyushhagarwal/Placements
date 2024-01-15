
class Solution {
    public static void main(String[] args) {

        // Implicit Casting (Widening or Automatic Casting):
        // Implicit casting occurs when a data type with a smaller size(Eg. int) is
        // automatically converted to a data type with a larger size(Eg. double) without
        // any explicit action from the programmer.
        int intValue = 10;
        double doubleValue = intValue; // Implicit casting from int to double

        // In the example above, the int value is implicitly cast to a double without
        // any explicit conversion.

        // Explicit Casting (Narrowing or Manual Casting):
        // Explicit casting occurs when a data type with a larger size(Eg. double) is
        // manually converted to a data type with a smaller size(Eg. int).
        double doubleValue2 = 10.99;
        int intValue2 = (int) doubleValue2; // Explicit casting from double to int
        // In the example above, the double value is explicitly cast to an int by
        // placing the int keyword in front of the double value.

        // Converting Numbers to Strings by concatenating with an empty string
        int intValue3 = 10;
        String stringValue = "" + intValue3;
        System.out.println(stringValue); // 10
    }
}