package SearchingSorting;

class BinarySearch {
    static int binarySearch(int arr[], int n, int key) {
        int start = 0;
        int end = n - 1;
        int mid = (start + end) / 2; // start + (end - start)/2

        while (start <= end) {
            if (arr[mid] == key) {
                return mid;
            }

            if (key > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = (start + end) / 2;
        }
        return -1;

    }
}
