package Arrays;

import java.util.HashMap;
import java.util.Map;

class DuplicateElemnent {
    static int dup(int arr[]) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i < n; i++) {
            map.put(i, 0);
        }

        for (int i = 0; i < n; i++) {
            int count = map.get(arr[i]);
            count++;
            map.put(arr[i], count);
            if (count == 2) {
                return arr[i];
            }
        }

        return 0;
    }

    static int dupXor(int arr[]) {
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }
        return ans;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 2 };
        System.out.println(dupXor(arr));

    }
}
