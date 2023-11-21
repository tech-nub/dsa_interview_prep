"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/best-time-to-buy-and-sell-stock
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. Sliding Window technique uses 2 pointers to track the current result set until we get a better result set in that case we change our window.
2. In this case, profit is made when we buy low and sell high. Max profit is when we buy lowest and sell highest.
2. Initially window size is 1 ( r= 1, l = 0) where l is when we buy and r is when we sell and we keep considering l = 0 as the lowest rate we can buy and we keep moving r and keep saving the max difference.
3. Once we find another position which is lower than l, then we move l to that position and then expand the window from there. 

"""

class LeetCode121 {
    public int maxProfit(int[] prices) {
        // Sliding Window approach
        int l = 0;
        int r = 1;

        int maxProfit = 0;

        // We will only make profit when we buy at low and sell at high
        // So, we start our window of size 1 initially (r = 1, l = 0)
        // and iterate through array.
        while(r < prices.length) {
            // If we get prices at r less than 
            // prices at l, it means we have profit
            if(prices[l] < prices[r]) {
                // Update the max profit
                maxProfit = Math.max(maxProfit, (prices[r] - prices[l]));                
            }// else we have found another lower price than previous l, 
            // hence shrink the window and bring l to r. 
            else {
                l = r;
            }

            // Keep incrmenting r to expand the window
            r++;
        }
        return maxProfit;
    }
}