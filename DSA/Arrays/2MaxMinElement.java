// Maximum and minimum of an array using minimum number of comparisons
// Link: https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

package Arrays;

class MaxMinElement {
    public static int maxElement(int input_array[], int size) {
        int max_element = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (input_array[i] > max_element) {
                max_element = input_array[i];
            }
        }
        return max_element;
    }

    public static int minElement(int input_array[], int size) {
        int min_element = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (input_array[i] < min_element) {
                min_element = input_array[i];
            }
        }
        return min_element;
    }

    // Time Complexity : O(n)
    // Space Complexity : O(1)
    public static void main(String[] args) {
        int input_array[] = { 2, 4, 5, 2, 77, 1 };
        int size = input_array.length;
        int max_element = maxElement(input_array, size);
        int min_element = minElement(input_array, size);
        System.out.println("Max element is: " + max_element);
        System.out.println("Min element is: " + min_element);
    }

}
