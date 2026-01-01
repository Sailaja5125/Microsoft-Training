public class RansomNote {


    // 2️⃣ Better Approach (HashMap / Frequency Count)
    public boolean canConstructBetter(String ransomNote, String magazine) {
        int[] freq = new int[26]; // frequency of letters in magazine
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()){
            freq[c - 'a']--;
            if (freq[c - 'a'] < 0) return false;
        }
        return true;
    }

    // 3️⃣ Optimal Approach (with early exit)
    public boolean canConstructOptimal(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] freq = new int[26];
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        return true;
    }

    // 🔍 Main method for quick testing
    public static void main(String[] args) {
        RansomNote rn = new RansomNote();

        System.out.println("Better: " + rn.canConstructBetter("aa", "ab"));    // false
        System.out.println("Optimal: " + rn.canConstructOptimal("a", "b"));    // false
    }
}