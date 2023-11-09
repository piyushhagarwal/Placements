//Given two arrays a[] and b[] of size n and m respectively.
//The task is to find the number of elements in the union between these two arrays.
//Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union
package Arrays;

import java.util.HashSet;

class DSA {

    static void union(int a[], int n, int b[], int m) {
        HashSet<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            s.add(a[i]);
        }

        for (int i = 0; i < n; i++) {
            s.add(b[i]);
        }

        System.out.println(s.toString());
    }

    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int n2 : nums2) {

            if (set1.contains(n2)) {
                set2.add(n2);
            }
        }

        // convert set to array
        int[] result = new int[set2.size()];
        int i = 0;
        for (int x : set2) {
            result[i] = x;
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 6, 2, 3, 5, 7, 3 };
        int b[] = { 2, 4, 5, 6, 8, 9, 4, 6, 5, 4 };

        union(a, a.length, b, b.length);
    }
}