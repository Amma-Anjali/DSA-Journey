/**
 * LeetCode Problem: 2586. Count the Number of Vowel Strings in Range
 * Link: https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range/
 *
 * Description:
 * Given a list of words and a list of query ranges [l, r],
 * count how many words within each range start and end with a vowel.
 *
 * This solution uses a prefix sum array to answer each query in O(1) time.
 *
 * Time Complexity:
 * - Preprocessing: O(n) for building prefix sum array
 * - Each query: O(1)
 * - Total: O(n + q) where n = words.length and q = number of queries
 */
public class Solution {

    /**
     * Main function to answer range vowel word queries.
     *
     * @param words   Array of lowercase strings.
     * @param queries 2D array of query ranges [left, right].
     * @return Array of answers for each query.
     */
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n + 1];  // Prefix sum array

        // Build prefix sum of vowel-start-and-end words
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i] + (isVowelWord(words[i]) ? 1 : 0);
        }

        // Answer each query in O(1) using prefix sum
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            answer[i] = count[right + 1] - count[left];
        }

        return answer;
    }

    /**
     * Checks if a word starts and ends with a vowel.
     *
     * @param word Input word
     * @return true if both first and last characters are vowels
     */
    private boolean isVowelWord(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    /**
     * Checks if a character is a lowercase vowel.
     *
     * @param ch Input character
     * @return true if ch is one of 'a', 'e', 'i', 'o', 'u'
     */
    private boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}
