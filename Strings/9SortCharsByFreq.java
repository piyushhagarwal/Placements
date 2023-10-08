package Strings;

import java.util.HashMap;
import java.util.Map;

class SortCharsByFreq {
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("Four", 4);
        map.forEach(null);

        System.out.println(map.keySet().toString());
    }
}
