"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. We can buy and sell as many times as we want
2. We want to buy low and sell high
3. If price on current day is more than price on previous day, then it is time to sell and make profit.

"""

class LeetCode122 {
    public int maxProfit(int[] prices) {
        // Variable to keep track of the profit
        int profit = 0;

        for(int i = 1; i<prices.length; i++) {
            // We will make profit if and only if prices on ith day 
            // are greater than prices on previous day i.e. (i-1)th day
            if(prices[i] > prices[i-1]) {
                // Keep adding the profit
                profit = profit + (prices[i] - prices[i-1]);
            }
        }

        return profit;
    }
}