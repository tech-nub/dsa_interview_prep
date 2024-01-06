"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/container-with-most-water
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach one at the beginning of heights array and another at the end.
2. Water retained will be restricted by the lesser height hence after updating the current area, move the pointer whichever is at lesser height.

"""

class LeetCode11 {
    public int maxArea(int[] height) {
        // Take 2 pointers, 1 at the beginning and another
        // at the end of array
        int l = 0;
        int r = height.length - 1;
        // Keep track of max area so far
        int maxArea = 0;

        while (l < r) {
            // Current area will be width * heigh. Width will be (r-l)
            // and height will be minimum of 2 heights at l and r
            // because water will spill outside of lesser height of both
            int currArea = (r-l) * Math.min(height[l], height[r]);
            // Keep updating max area
            maxArea = Math.max(maxArea, currArea);
            // As we have to find max aea, hence move the pointer whichever
            // is at lesser height because that will restrict the water retention
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}