import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {

    // 1. Brute Force (O(n^2)) - not recommended hard to handle the duplicate characters !!
    public static boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) return false;
        boolean[] visited = new boolean[t.length()];
        for (int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (int j = 0; j < t.length(); j++) {
                if (!visited[j] && s.charAt(i) == t.charAt(j)) {
                    visited[j] = true;
                    found = true;
                    break;
                }
            }
            if (!found) return false;
        }
        return true;
    }

    // 2. Frequency Array (Best for lowercase English letters)
    public static boolean isAnagramArray(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        return true;
    }

    // 3. HashMap Approach (General case)
    public static boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
        }
        return map.isEmpty();
    }

    // 4. Sorting Approach
    public static boolean isAnagramSort(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        String s1 = "anagram";
        String t1 = "nagaram";
        String s2 = "rat";
        String t2 = "car";

        System.out.println("Brute Force: " + isAnagramBrute(s1, t1)); // true
        System.out.println("Frequency Array: " + isAnagramArray(s1, t1)); // true
        System.out.println("HashMap: " + isAnagramMap(s1, t1)); // true
        System.out.println("Sorting: " + isAnagramSort(s2, t2)); // false
    }
}