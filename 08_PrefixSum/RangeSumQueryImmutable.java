/**
 * LeetCode Problem: 303. Range Sum Query - Immutable
 * Link: https://leetcode.com/problems/range-sum-query-immutable/
 *
 * Description:
 * Implements a NumArray class using prefix sums to support fast O(1) range sum queries.
 * The constructor precomputes the prefix sums during initialization.
 *
 * Time Complexity:
 * - Constructor: O(n)
 * - sumRange: O(1)
 */
public class NumArray {

    private final int[] prefixSum;

    /**
     * Constructor: Builds the prefix sum array.
     *
     * @param nums The input array of integers.
     */
    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1]; // 1 extra space for easier indexing
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    /**
     * Returns the sum of elements between indices left and right (inclusive).
     *
     * @param left  Starting index of the range.
     * @param right Ending index of the range.
     * @return The sum from nums[left] to nums[right].
     */
    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
