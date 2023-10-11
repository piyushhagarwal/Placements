package Recursion;

class LinearSearch {
    public static int linearSearch(int index, int arr[], int key) {
        if (index > arr.length - 1) {
            return -1;
        }

        if (arr[index] == key) {
            return index;
        }

        return linearSearch(index + 1, arr, key);
    }

    public static int binarySearch(int arr[], int key, int start, int end) {
        int mid = start + (end - start) / 2;
        if (start > end) {
            return -1;
        } else {
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                return binarySearch(arr, key, start, mid - 1);
            } else {
                return binarySearch(arr, key, mid + 1, end);
            }
        }

    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 5, 10 };
        System.out.println(binarySearch(arr, 6, 0, arr.length - 1));
    }
}