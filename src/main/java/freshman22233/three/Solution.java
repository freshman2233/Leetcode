package freshman22233.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Constraints:
 *
 *     0 <= s.length <= 5 * 10^4
 *     s consists of English letters, digits, symbols and spaces.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;

        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for(int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            if(charIndexMap.containsKey(c)) {
                start = Math.max(start,charIndexMap.get(c) + 1);
            }

            charIndexMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")==3);
        System.out.println(solution.lengthOfLongestSubstring("bbbbb")==1);
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")==3);
        System.out.println(solution.lengthOfLongestSubstring("abba")==2);
    }
}
