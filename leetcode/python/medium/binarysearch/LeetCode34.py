"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
Time Complexity: O(log(n))
Space Complexity: O(1)

ALGO:

1. Modified Binary Search (BS). In normal BS, we stop the search as soon as element is found at m position but here we have to find the value at leftmost and rightmost position. So it can be at the left of m or right of m respectively.
2. Hence we do not stop the binary search once element is found, we keep going to the left once and another time we keep going to right to find the extreme target values.
3. Hence there will be 2 BS iterations and hence we find the solution in O(log(n)) time complexity instead of O(n) if we linearly search array.

"""

class LeetCode34(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        left = self.binarySearch(nums, target, True)
        right = self.binarySearch(nums, target, False)
        return [left, right]
    
    # Modified binary search. When we find the element, it does not mean that 
    # it is the left/right most element so we will continue our binary search
    # once to the left and once to the right depending on lookLeft flag
    def binarySearch(self, nums, target, lookLeft):
        l, r = 0, len(nums) - 1
        i = -1
        while l <= r:
            m = (l + r) // 2
            if target > nums[m]:
                l = m + 1
            elif target < nums[m]:
                r = m - 1
            else:
                # Keep saving the index as soon as match found
                i = m
                if lookLeft:
                    r = m - 1
                else:
                    l = m + 1
        return i

 