/**
 * LeetCode Problem: 2483. Minimum Penalty for a Shop
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-penalty-for-a-shop/
 *
 * Optimized Approach:
 * - Instead of using prefix/suffix arrays, we use a running penalty score.
 * - Every 'Y' before closing adds penalty (so we subtract 1).
 * - Every 'N' after closing adds penalty (so we add 1).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumPenaltyShop {

    public int bestClosingTime(String customers) {
        int minPenalty = 0;
        int penalty = 0;
        int bestHour = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--; // early close loses a customer
            } else {
                penalty++; // keeping shop open when no customer
            }

            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}

/*
Using Prefix + Suffix Arrays :

int n = customers.length();
int[] NCount = new int[n + 1];
int[] YCount = new int[n + 1];

// Build prefix sum for 'N'
for (int i = 0; i < n; i++) {
    NCount[i + 1] = NCount[i] + (customers.charAt(i) == 'N' ? 1 : 0);
}

// Build suffix sum for 'Y'
for (int i = n - 1; i >= 0; i--) {
    YCount[i] = YCount[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
}

// Try each hour
int minPenalty = Integer.MAX_VALUE;
int bestHour = -1;
for (int i = 0; i <= n; i++) {
    int currPenalty = NCount[i] + YCount[i];
    if (currPenalty < minPenalty) {
        minPenalty = currPenalty;
        bestHour = i;
    }
}
return bestHour;

// Time: O(n), Space: O(n)
*/
