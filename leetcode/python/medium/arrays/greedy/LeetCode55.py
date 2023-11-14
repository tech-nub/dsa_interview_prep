"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/jump-game
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. Apply Greedy Approach. Let's start from the end where we finally have to reach.
2. If we can reach to last position from 2nd last position then we can set our target to 2nd last position.
3. Keep moving the target to the left.
4. If somehow target reaches the 1st position, it means we have a path from last to 1st and hence vice versa.

"""

class LeetCode55(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # This is the last position where we have to finally reach
        posToReach = len(nums) - 1

        # Start from 2nd last position and move backwards
        for i in range(len(nums)-2, -1, -1):
            # If the position where we are currently and the jump we can take
            # from there add up to the posToReach, then we can move posToReach
            # to the current position
            if nums[i] + i >= posToReach:
                posToReach = i

        # At the end of posToReach is updated to 0th index, it means we can 
        # reach the last position from 1st position
        return True if posToReach == 0 else False 