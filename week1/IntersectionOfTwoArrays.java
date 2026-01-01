import java.util.*;

class IntersectionOfArrays {

    // ------------------------------------------------------------
    // 1️⃣ Brute Force Approach
    // ------------------------------------------------------------
    // Explanation:
    // - Compare each element of nums1 with each element of nums2.
    // - If they match, add to a result set (to avoid duplicates).
    // - Very inefficient for large arrays.
    // Time Complexity: O(n * m) where n and m are lengths of nums1 and nums2.
    // Space Complexity: O(min(n, m)) for storing intersection.
    public static int[] bruteForce(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            for (int j : nums2) {
                if (i == j) {
                    result.add(i);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ------------------------------------------------------------
    // 2️⃣ Better Approach (HashSet)
    // ------------------------------------------------------------
    // Explanation:
    // - Store all elements of nums1 in a HashSet.
    // - Traverse nums2, if element exists in HashSet, add to result set.
    // - Ensures uniqueness automatically.
    // Time Complexity: O(n + m).
    // Space Complexity: O(n) for HashSet.
    public static int[] hashSetApproach(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int j : nums2) {
            if (set.contains(j)) {
                result.add(j);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ------------------------------------------------------------
    // 3️⃣ Optimal Approach (Sorting + Two Pointers)
    // ------------------------------------------------------------
    // Explanation:
    // - Sort both arrays.
    // - Use two pointers to traverse both arrays simultaneously.
    // - If nums1[i] == nums2[j], add to result and move both pointers.
    // - If nums1[i] < nums2[j], move i forward; else move j forward.
    // - Avoid duplicates by using a set or checking last inserted element.
    // Time Complexity: O(n log n + m log m) due to sorting.
    // Space Complexity: O(min(n, m)).
    public static int[] twoPointerApproach(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> result = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // ------------------------------------------------------------
    // 🔎 Test all approaches
    // ------------------------------------------------------------
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        System.out.println("Brute Force Result: " + Arrays.toString(bruteForce(nums1, nums2)));
        System.out.println("HashSet Result: " + Arrays.toString(hashSetApproach(nums1, nums2)));
        System.out.println("Two Pointer Result: " + Arrays.toString(twoPointerApproach(nums1, nums2)));
    }
}