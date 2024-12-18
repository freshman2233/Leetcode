package freshman22233.four;

/**
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
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
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to minimize binary search range
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;

        int half = (total + 1) / 2; // Half count (if odd, this gives the extra one to the left side)

        int left = 0;
        int right = m;

        while (left <= right) {
            int i = (left + right) / 2;        // Partition on nums1
            int j = half - i;                  // Partition on nums2

            // If i == 0, it means nothing on the left side of nums1, use -∞ as boundary
            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            // If i == m, it means nothing on the right side of nums1, use +∞ as boundary
            int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            // Same for nums2
            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Check if we have a proper partition
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                // Correct partition found
                if ((total % 2) == 0) {
                    // Even total length
                    return ((double)Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    // Odd total length
                    return (double)Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                // Too far right in nums1, move left
                right = i - 1;
            } else {
                // Too far left in nums1, move right
                left = i + 1;
            }
        }

        // Given the constraints, the loop should always return from inside.
        // If we reach here, it means something unexpected happened.
        throw new IllegalArgumentException("No median found. Input arrays were not properly sorted or empty.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2) == 2.00000);

        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4) == 2.50000);
    }
}
