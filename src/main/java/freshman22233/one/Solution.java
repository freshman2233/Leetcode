package freshman22233.one;

import java.util.HashMap;

/**
 * 1. Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Constraints:
 *     2 <= nums.length <= 10^4
 *     -10^9 <= nums[i] <= 10^9
 *     -10^9 <= target <= 10^9
 *     Only one valid answer exists.
 *     Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsIndex.containsKey(target - nums[i])) {
                return new int[]{numsIndex.get(target - nums[i]), i};
            }
            numsIndex.put(nums[i], i);
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(java.util.Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        System.out.println(java.util.Arrays.equals(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        System.out.println(java.util.Arrays.equals(twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
    }
}