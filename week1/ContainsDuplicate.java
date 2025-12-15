import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    // 1. Brute Force: Sort + Check Neighbors
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums); // O(n log n)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true; // duplicate found
            }
        }
        return false; // no duplicates
    }

    // 2. Better Approach: HashSet
    public static boolean containsDuplicateSet(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }
        return false; // no duplicates
    }

    // 3. Alternative: Compare Lengths of Array and Set
    public static boolean containsDuplicateLength(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length; // if set smaller, duplicates exist
    }

    // Main method to test all approaches
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 2, 3};

        System.out.println("Brute Force (Sort): " + containsDuplicateSort(nums1)); 
        System.out.println("HashSet Approach: " + containsDuplicateSet(nums2)); 
        System.out.println("Length Comparison: " + containsDuplicateLength(nums3)); 
    }
}