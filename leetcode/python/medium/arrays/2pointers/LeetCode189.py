"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/rotate-array
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. Rotating the array by k positions has an algo:
2. STEP 1: Reverse the complete Array
3. STEP 2: Reverse the first k elements of the resultant array in STEP 1
4. STEP 3: Reverse the k+1 to end part of resultant array in STEP 2.

"""

class LeetCode189(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # 2 pointer technique
        k = k % len(nums)
        l, r = 0, len(nums) - 1

        # Reverse the whole array
        # [1,2,3,4,5,6,7] --> [7,6,5,4,3,2,1]
        while l < r:
            # Swap left and right element
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l + 1, r - 1

        # Reverse the first k part e.g. if k = 3
        # [7,6,5,4,3,2,1] --> [5,6,7,4,3,2,1]
        l, r = 0, k - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l + 1, r - 1
        
        # Reverse rest of the portion if k = 3
        # [5,7,6,4,3,2,1] --> [5,6,7,1,2,3,4]
        l, r = k, len(nums) - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l, r = l + 1, r - 1
        
    