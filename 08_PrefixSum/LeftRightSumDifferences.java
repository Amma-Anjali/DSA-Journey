// LeetCode: https://leetcode.com/problems/left-and-right-sum-differences/
// Topic: Prefix Sum
// Difficulty: Easy
// Description:
//   For each index i, return the absolute difference between
//   the sum of elements to the left of i and the sum of elements to the right of i.

class Solution {
    public int[] leftRightDifference(int[] nums) {
        int rightSum = 0;
        int[] answer = new int[nums.length];

        // Step 1: Calculate total sum (used as initial right sum)
        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        // Step 2: Calculate prefix difference for each index
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i]; // remove current from right sum
            answer[i] = Math.abs(leftSum - rightSum); // store absolute diff
            leftSum += nums[i]; // add current to left sum
        }

        return answer;
    }
}
