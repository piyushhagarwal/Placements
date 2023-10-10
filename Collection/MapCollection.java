package Collection;

import java.util.HashMap;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;

public class MapCollection {
    public static void main(String[] args) {
        // 1. Initialization
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 2. Insertion or updation
        hashMap.put("John", 25);
        hashMap.put("Jane", 30);

        // 3. Deletion
        hashMap.remove("Jane");

        // 4. Get Value
        int johnsAge = hashMap.get("John");
        System.out.println("John's Age: " + johnsAge);

        // 5. Check if Key Exists
        boolean containsJohn = hashMap.containsKey("John");
        System.out.println("Contains John: " + containsJohn);

        // 6. Check if Value Exists
        boolean containsAge30 = hashMap.containsValue(30);
        System.out.println("Contains Age 30: " + containsAge30);

        // 7. Size
        int size = hashMap.size();
        System.out.println("Size of HashMap: " + size);

        // 9. Clear
        hashMap.clear();
        System.out.println("HashMap after clearing: " + hashMap);

        // 10. Using getOrDefault
        // If key exists, return value, else return default value
        // If key does not exist in HashMap it gets added to the HashMap
        int marysAge = hashMap.getOrDefault("Mary", 0);
        System.out.println("Mary's Age: " + marysAge);

        // 11. Get Keys
        // Returns a Set of all the keys in the HashMap
        Set<String> keys = hashMap.keySet();
        System.out.println("Keys in HashMap: " + keys);

        // 12. Get Values
        // Returns a Collection of all the values in the HashMap
        Collection<Integer> values = hashMap.values();
        System.out.println("Values in HashMap: " + values);

        // Get max and min value in the Collection values
        int maxValue = Collections.max(values);
        int minValue = Collections.min(values);

    }
}
