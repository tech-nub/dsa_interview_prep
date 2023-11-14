"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/trapping-rain-water
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

TBD

"""

class LeetCode42 {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        // 2 pointer technique
        int l = 0;
        int r = height.length - 1;
        // Final trapped water
        int res = 0;

        // Keep a record of max height on the left and right as 
        // that will limit how much water we can trap. 
        // Whichever is lesser will limit the trapped water
        int maxLeft = height[l];
        int maxRight = height[r];

        while(l < r) {
            // Whichever is lesser, move that pointer            
            if(maxLeft <= maxRight) {   
                l++; 
                // Recalculate the max height at the left
                maxLeft = Math.max(maxLeft, height[l]);
                // "maxLeft - height[l]" This works because maxLeft 
                // specifies the boundary limit (maxLeft < maxRight) and 
                // at one place you can store (maxLeft) amount of water - height 
                // of that place itself because height will take away the space where 
                // there could be water. Same for else condition
                res = res + maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(maxRight, height[r]);
                res = res +  maxRight - height[r];
            }
        }
        return res;
    }
}

