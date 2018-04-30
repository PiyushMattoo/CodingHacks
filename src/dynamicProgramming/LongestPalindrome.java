/*
 https://leetcode.com/problems/longest-palindromic-substring/description/
 */
package dynamicProgramming;

/**
 *
 * @author mattoop
 */
public class LongestPalindrome {

    public static void main(String[] str) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("bb"));
    }

    public String longestPalindrome(String s) {
        int start = 0;
        int length = s.length();
        boolean[][] palindrome = new boolean[length][length];

        //Sub-strings of length 1
        int maxLength = 1;
        for (int i = 0; i < length - 1; i++) {
            palindrome[i][i] = true;
        }

        //Sub-string of length 2
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindrome[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        //Sub-string of length 3
        for (int i = 3; i <= length; i++) {
            for (int j = 0; j < length - i + 1; j++) {
                int k = i + j - 1;

                if (palindrome[j + 1][k - 1] && s.charAt(j) == s.charAt(k)) {
                    palindrome[j][k] = true;
                    if (i > maxLength) {
                        start = j;
                        maxLength = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
