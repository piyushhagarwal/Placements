//Given an array, rotate the array by one position in clock-wise direction.
// Input:
// N = 5
// A[] = {1, 2, 3, 4, 5}
// Output:
// 5 1 2 3 4

package Arrays;

class CyclicRotate {

    static void cyclicRotate(int arr[], int n) {
        int lastElement = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;

    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5 };
        cyclicRotate(arr, 5);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}