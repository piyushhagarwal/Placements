package Strings;

import java.util.HashMap;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // Create two HashMaps to store character frequencies for each string
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // Populate map1 with character frequencies from string s
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            // If the key already exists, increment its count
            if (map1.containsKey(key)) {
                map1.replace(key, map1.get(key) + 1);
            } else {
                // If the key is not present, add it to the map with count 1
                map1.put(key, 1);
            }
        }

        // Populate map2 with character frequencies from string t
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            // If the key already exists, increment its count
            if (map2.containsKey(key)) {
                map2.replace(key, map2.get(key) + 1);
            } else {
                // If the key is not present, add it to the map with count 1
                map2.put(key, 1);
            }
        }

        // Check if the two maps are equal, i.e., if they have the same character
        // frequencies
        if (map1.equals(map2)) {
            // If equal, the strings are anagrams
            return true;
        } else {
            // If not equal, the strings are not anagrams
            return false;
        }
    }

}
