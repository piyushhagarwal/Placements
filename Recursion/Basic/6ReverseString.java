package Recursion.Basic;

class ReverseString {
    public static void reverse(StringBuffer str, int start, int end) {
        if (start >= end) {
            return;
        }
        char temp = str.charAt(start);
        str.setCharAt(start, str.charAt(end));
        str.setCharAt(end, temp);

        reverse(str, start + 1, end - 1);
    }

    public static void main(String args[]) {
        StringBuffer str = new StringBuffer("Hello");
        reverse(str, 0, str.length() - 1);
        System.out.println(str);
    }
}
