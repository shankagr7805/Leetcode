import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strs) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int count : freq) {
                keyBuilder.append('#');
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        
        return new ArrayList<>(map.values());
    }
}