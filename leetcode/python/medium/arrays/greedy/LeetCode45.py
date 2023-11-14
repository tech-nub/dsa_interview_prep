"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/jump-game-ii
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. Apply Greedy Approach. As we have to minimize number of jumps, so we have to consider where at min and at max we can reach from current position.
2. That min and max position will act like a window to calculate the next max position. This will act like a Breadth First Search window as we have to iterate through every position in that window.
3. e.g. if we are at position from where we can make max jump of 2, we will consider a window to be from 1 to 2 because value at any index can be bigger
4. left pointer will simply move to next of previous r position and r will point to next max position.
5. With every jump keep incrementing the jump count result variable.

"""

class LeetCode45(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # This uses Greedy and BFS approach. 

        # resultant no. of jumps, left and right of current window
        res, l, r = 0, 0, 0

        while r < (len(nums) - 1):
            # This is the max we can jump from the current window
            maxJumpPos = 0
            # Iterate through current window and keep on updating the farthest
            # position from current window
            for i in range(l, r + 1):
                maxJumpPos = max(maxJumpPos, i + nums[i])

            # Move the window, move l to next of r i.e. r+1 and r to the 
            # max jump position we can reach from current window
            l = r + 1
            r = maxJumpPos

            # Also, with every iteration keep incrementing the jump count
            res += 1
        return res