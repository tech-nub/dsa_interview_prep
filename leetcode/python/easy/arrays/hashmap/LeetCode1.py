"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/two-sum
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. Use a hashmap of Difference (target - 'number') and index of 'number'
2. Now iterate through all the numbers and if number exists in hashmap then it means we have found our solution. e.g. if target is 7 and our current number is 3 and if difference (7-3=4) exists in hashmap then we have found our number.

"""

class LeetCode1(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Map of Difference (target - 'number') and 
        # index of 'number'
        indexDiff = {}

        for i, n in enumerate(nums):
            # If number in map is same as (target - nums[i]) 
            # then we have found our solution
            if target - n in indexDiff:
                return [indexDiff[target - n], i]
            # Keep adding to the map the difference of the 
            # number and target and index
            indexDiff[n] = i

