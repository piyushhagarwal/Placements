package Recursion.Basic;

class GetSum {

    public static int getSum(int index, int[] arr) {
        if (index > arr.length - 1) {
            return 0;
        }

        return arr[index] + getSum(index + 1, arr);
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 4, 5, 10 };
        System.out.println(getSum(0, arr));
    }
}
