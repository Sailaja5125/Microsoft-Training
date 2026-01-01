import java.util.*;

public class MajorityElement {

    // ------------------------------------------------------------
    // 1️⃣ Brute Force Approach
    // ------------------------------------------------------------
    // Explanation (your notes):
    // The brute force is to sort the elements and find the maximum count.
    // If previous element == next element then count++.
    // If the current count > maxCount then update maxCount.
    // Time Complexity: O(n^2) if nested loops, or O(n log n) with sorting.
    // Space Complexity: O(1).
    public static int bruteForce(int[] nums) {
        Arrays.sort(nums);
        int count = 1, maxCount = 1, majority = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                majority = nums[i];
            }
        }

        if (maxCount > nums.length / 2) {
            return majority;
        } else {
            throw new IllegalArgumentException("No majority element found (Brute Force)");
        }
    }

    // ------------------------------------------------------------
    // 2️⃣ Better Approach (HashMap Frequency Count)
    // ------------------------------------------------------------
    // Explanation (your notes):
    // Use a HashMap to store key as element and value as frequency.
    // Time Complexity: O(n).
    // Space Complexity: O(n).
    // Accessing HashMap is O(log n) in worst case, but average O(1).
    public static int hashMapApproach(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > nums.length / 2) {
                return num;
            }
        }

        throw new IllegalArgumentException("No majority element found (HashMap)");
    }

    // ------------------------------------------------------------
    // 3️⃣ Optimal Approach (Boyer-Moore Voting Algorithm)
    // ------------------------------------------------------------
    // Explanation (your notes):
    // Initialize two variables: first (count) and second (candidate).
    // Assume majority element is nums[0].
    // If the next element is same as candidate → count++.
    // If different → count--.
    // If count <= 0 → change candidate to current element and reset count.
    // At the end, if there exists an element whose frequency > n/2,
    // then candidate is the majority element.
    // Time Complexity: O(n).
    // Space Complexity: O(1).
    public static int boyerMoore(int[] nums) {
        int count = 0, candidate = 0;

        // Phase 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Phase 2: Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            throw new IllegalArgumentException("No majority element found (Boyer-Moore)");
        }
    }

    // ------------------------------------------------------------
    // 🔎 Test all approaches
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {3, 3, 4, 2, 3, 3, 5};

        System.out.println("Brute Force Result: " + bruteForce(nums));
        System.out.println("HashMap Result: " + hashMapApproach(nums));
        System.out.println("Boyer-Moore Result: " + boyerMoore(nums));
    }
}