package Recursion.Basic;

class IsSorted {
    public static boolean isSorted(int index, int[] arr) {
        if (index > arr.length - 2) {
            return true;
        }

        if (arr[index] <= arr[index + 1]) {
            return isSorted(index + 1, arr);
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 2, 4, 3, 6, 7, 8 };
        System.out.println(isSorted(0, arr));
    }
}
