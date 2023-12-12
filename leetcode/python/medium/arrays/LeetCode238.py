"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/product-of-array-except-self
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. We will iterate through nums array twice.
2. First iterate in the forward direction and find the product of the numbers before a particular index and save it that index itself.
3. Then go the reverse and multiply the index value (product of values before that index) with product of numbers after it and save it in the resultant index.

"""

class LeetCode238(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        res = [1] * (len(nums))
        runningProductBefore = 1

        # Save in the result array all the products before i
        for i in range (len(nums)):
            res[i] = runningProductBefore
            runningProductBefore = runningProductBefore * nums[i]

        runningProductAfter = 1
        # Save in result array product before num * product after num
        for i in range (len(nums) - 1, -1, -1):
            # final current index value will be running product after 
            # current index multiplied with current value at index i 
            # in res array which was precomputed earlier
            res[i] = runningProductAfter * res[i]

            # Running product after will be updated with addition of 
            # current number in original array at index i
            runningProductAfter = runningProductAfter * nums[i]

        return res
        
        