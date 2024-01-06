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

class LeetCode11(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        # Take 2 pointers, 1 at the beginning and another
        # at the end of array
        l, r = 0, len(height) - 1
        # Keep track of max area so far
        maxArea = 0
        while l < r:
            # Current area will be width * heigh. Width will be (r-l)
            # and height will be minimum of 2 heights at l and r
            # because water will spill outside of lesser height of both
            area = (r - l) * min(height[l], height[r])
            # Keep updating max area
            maxArea = max(maxArea, area)
            # As we have to find max aea, hence move the pointer whichever
            # is at lesser height because that will restrict the water retention
            if height[l] < height[r]:
                l+=1
            else:
                r -=1
        
        return maxArea

