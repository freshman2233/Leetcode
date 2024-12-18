package freshman22233.four;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5
 *
 * Constraints:
 *     nums1.length == m
 *     nums2.length == n
 *     0 <= m <= 1000
 *     0 <= n <= 1000
 *     1 <= m + n <= 2000
 *     -10^6 <= nums1[i], nums2[i] <= 10^6
 */
public class Solution_2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];

        // Merge the two arrays
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements of nums1, if any
        while (i < m) {
            merged[k++] = nums1[i++];
        }

        // Copy remaining elements of nums2, if any
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Find the median
        int totalLength = m + n;
        if (totalLength % 2 == 1) {
            return merged[totalLength / 2];
        } else {
            return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();

        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2) == 2.00000);

        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4) == 2.50000);
    }
}

