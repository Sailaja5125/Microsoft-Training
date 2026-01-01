import java.util.Arrays;

class MoveZeroes {

    // ------------------------------------------------------------
    // 1️⃣ Brute Force Approach
    // ------------------------------------------------------------
    // Explanation (your notes):
    // - Create a new array `ans` of the same size.
    // - Traverse the input array, copy non-zero elements into `ans`.
    // - Remaining positions will be filled with 0 by default (in Java).
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static int[] bruteForce(int[] nums) {
        int[] ans = new int[nums.length];
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                ans[j++] = num;
            }
        }
        return ans;
    }

    // ------------------------------------------------------------
    // 2️⃣ Better Approach (In-place shifting)
    // ------------------------------------------------------------
    // Explanation:
    // - Use two passes.
    // - First pass: move all non-zero elements forward in the same array.
    // - Second pass: fill the remaining positions with zero.
    // Time Complexity: O(n)
    // Space Complexity: O(1) (in-place)
    public static void betterApproach(int[] nums) {
        int j = 0; // pointer for placing non-zero elements
        for (int num : nums) {
            if (num != 0) {
                nums[j++] = num;
            }
        }
        // Fill remaining positions with zero
        while (j < nums.length) {
            nums[j++] = 0;
        }
    }

    // ------------------------------------------------------------
    // 3️⃣ Optimal Approach (Two-pointer swap)
    // ------------------------------------------------------------
    // Explanation:
    // - Use two pointers: `i` (current index) and `j` (position for next non-zero).
    // - Traverse the array:
    //   - If nums[i] != 0, swap nums[i] with nums[j], then increment j.
    // - This ensures non-zero elements are kept in order and zeroes pushed to the end.
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void optimalApproach(int[] nums) {
        int j = 0; // pointer for next non-zero position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap only if i != j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    // ------------------------------------------------------------
    // 🔎 Test all approaches
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        // Brute Force
        int[] bruteResult = bruteForce(nums);
        System.out.println("Brute Force Result: " + Arrays.toString(bruteResult));

        // Better Approach
        int[] betterResult = Arrays.copyOf(nums, nums.length);
        betterApproach(betterResult);
        System.out.println("Better Approach Result: " + Arrays.toString(betterResult));

        // Optimal Approach
        int[] optimalResult = Arrays.copyOf(nums, nums.length);
        optimalApproach(optimalResult);
        System.out.println("Optimal Approach Result: " + Arrays.toString(optimalResult));
    }
}