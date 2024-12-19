package freshman22233.five;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 *Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 *Constraints:
 *     1 <= s.length <= 1000
 *     s consist of only digits and English letters.
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // Consider odd length palindrome with center at i
            int len1 = expandFromCenter(s, i, i);
            // Consider even length palindrome with center between i and i+1
            int len2 = expandFromCenter(s, i, i+1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                // Update the start and end indices of the longest palindrome found
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Expands around the center defined by left and right indices
    // and returns the length of the palindrome found.
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // When the while loop ends, left and right are one step beyond the palindrome boundaries.
        return right - left - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad").equals("bab"));
        System.out.println(solution.longestPalindrome("cbbd").equals("bb"));
    }
}
