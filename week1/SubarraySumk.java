import java.util.HashMap;

public class SubarraySumk {

    /**
     * 1️⃣ Brute Force Approach
     * -----------------------
     * Idea:
     * - Use two nested loops to check all possible subarrays.
     * - For each starting index i, accumulate the sum until j.
     * - If the sum equals k, increment the count.
     *
     * Time Complexity: O(n^2)  (because of nested loops)
     * Space Complexity: O(1)
     */
    public int subarraySumBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j]; // accumulate subarray sum
                if (sum == k) {
                    count++; // found a valid subarray
                }
            }
        }
        return count;
    }

    /**
     * 2️⃣ Better Approach (Prefix Sum + HashMap)
     * ------------------------------------------
     * Idea:
     * - Maintain a running prefix sum while iterating.
     * - Use a HashMap to store how many times each prefix sum has occurred.
     * - For each prefix sum, check if (prefixSum - k) exists in the map.
     *   If yes, it means there is a subarray ending at current index with sum = k.
     *
     * Example:
     * nums = [1,2,3], k = 3
     * prefix sums: 1, 3, 6
     * When prefixSum = 3, (prefixSum - k) = 0 exists in map → count++
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) (for hashmap)
     */
    public int subarraySumBetter(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); // base case: prefix sum 0 occurs once

        int count = 0;
        int prefixSum = 0;

        for (int num : nums) {
            prefixSum += num;

            // check if prefixSum - k exists
            if (prefixMap.containsKey(prefixSum - k)) {
                count += prefixMap.get(prefixSum - k);
            }

            // update map with current prefixSum
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // 🔍 Quick test
    public static void main(String[] args) {
        SubarraySumk solver = new SubarraySumk();

        int[] nums1 = {1, 1, 1};
        System.out.println("Brute: " + solver.subarraySumBrute(nums1, 2));   // 2
        System.out.println("Better: " + solver.subarraySumBetter(nums1, 2)); // 2

        int[] nums2 = {1, 2, 3};
        System.out.println("Brute: " + solver.subarraySumBrute(nums2, 3));   // 2
        System.out.println("Better: " + solver.subarraySumBetter(nums2, 3)); // 2
    }
}