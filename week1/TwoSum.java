import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7};
        int target = 7;

        // brute force
        /**
         * using nested for loops
         * i iterating from 0 : n
         * j from i+1 : n
         * if arr[i] + arr[j] == target then return the numbers / indices
         * Time Complexity: O(n^2)
         */
        System.out.println("Brute Force: " + Arrays.toString(twoSumBruteForce(arr, target)));

        // better
        /**
         * using hashmap
         * for loop iterates over every element in the array
         * the difference of target and the element is searched in the hashmap
         * if the difference(key) is found then return the indices / numbers
         * Time Complexity: O(n), Space Complexity: O(n)
         */
        System.out.println("HashMap: " + Arrays.toString(twoSumHashMap(arr, target)));

        // best
        /**
         * sort the array
         * use two pointers one at the starting index and another at the end of the array
         * if the sum < target increment left pointer
         * if the sum > target decrement right pointer
         * if sum == target then return numbers
         * This approach may not work when indices are required because sorting changes positions
         * Time Complexity: O(n log n) due to sorting, then O(n) for two-pointer scan
         */
        System.out.println("Two Pointers: " + Arrays.toString(twoSumTwoPointers(arr, target)));
    }

    // Brute force solution
    public static int[] twoSumBruteForce(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j}; // return indices
                }
            }
        }
        return new int[]{-1, -1};
    }

    // HashMap solution
    public static int[] twoSumHashMap(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // return indices
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    // Two-pointer solution (returns numbers, not indices)
    public static int[] twoSumTwoPointers(int[] arr, int target) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int left = 0, right = sorted.length - 1;
        while (left < right) {
            int sum = sorted[left] + sorted[right];
            if (sum == target) {
                return new int[]{sorted[left], sorted[right]}; // return numbers
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}