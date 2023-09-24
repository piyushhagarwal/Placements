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

    static void intersection(int a[], int b[]) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num : a) {
            set1.add(num);
        }

        for (int num : b) {
            set2.add(num);
        }

        // By doing this duplicate values will be eliminated ^

        set1.retainAll(set2);

        System.out.println(set1.toString());
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 5, 6, 2, 3, 5, 7, 3 };
        int b[] = { 2, 4, 5, 6, 8, 9, 4, 6, 5, 4 };

        union(a, a.length, b, b.length);
        intersection(a, b);
    }
}