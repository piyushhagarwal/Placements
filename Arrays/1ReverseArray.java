// Given an array (or string), the task is to reverse the array/string.

package Arrays;

class ReverseArray {
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int temp = 0;

        while (start < end) {
            // Swapping the elements
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Incrementing start and decrementing end
            start++;
            end--;
        }
    }
    // Time Complexity : O(n)
    // Space Complexity : O(1)

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        reverseArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
