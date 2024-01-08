"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/3sum
Time Complexity: O(n^2)
Space Complexity: O(1)

ALGO:

1. Fix one element at a time and try to find other 2 numbers using 2 pointers l and r.
2. Sort the array first because array can contain duplicate numbers. Sorting would help to remove duplicates easily as we can check consecutive elements.
3. keep adding the matches to result set as we have to find all the matching combinations.


"""
class LeetCode15(object):
    def threeSum(self, nums):
        res = []
        # Sort the array because we want to get rid of duplicate numbers
        nums.sort()

        for i, a in enumerate(nums):
            if i > 0 and a == nums[i - 1]:
                continue

            l, r = i + 1, len(nums) - 1
            # Sum of all 3 nums should be 0 hence sum of other 2 numbers 
            # should be 0 minus this number
            target = 0 - a
            # Start 2 pointer approach, where l is at the 1st position of 
            # the remaining array and r is at the end of remaining array
            # If we found the sum, then save it and move l and r until
            # we get rid of duplicate numbers. If sum > target means
            # we need to bring r closer to l else move l closer to r
            while l < r:
                if nums[l] + nums[r] > target:
                    r -= 1
                elif nums[l] + nums[r] < target:
                    l += 1
                else:
                    res.append([a, nums[l], nums[r]])
                    l += 1
                    r -= 1
                    while nums[l] == nums[l - 1] and l < r:
                        l += 1
                        
        return res
        
