package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

class Solution {

    public static int distinctChars(String subStr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < subStr.length(); i++) {
            set.add(subStr.charAt(i));
        }
        return set.size();
    }

    public static int countSubStrings(String str, int k) {
        int count = 0;
        List<String> substrings = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String s = str.substring(i, j + 1);
                substrings.add(s);
            }
        }

        for (String subStr : substrings) {
            if (subStr.length() >= k && distinctChars(subStr) == k) {
                count++;
            }
        }

        return count;

    }
}