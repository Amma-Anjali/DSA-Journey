// LeetCode: https://leetcode.com/problems/range-sum-query-immutable/
// Topic: Prefix Sum
// Difficulty: Easy
<<<<<<< HEAD
=======
// Description:
//   Builds a prefix sum array during construction.
//   Allows fast O(1) range sum queries using the difference of prefix sums.

>>>>>>> 056fde36651bff1ebbb04cf925dd15cb008eb095
class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
}
