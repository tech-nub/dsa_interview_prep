"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/search-in-rotated-sorted-array
Time Complexity: O(log(n))
Space Complexity: O(1)

ALGO:

1. Binary search. This makes use of the fact that rotated sorted array will have 2 sorted portion, left sorted and right sorted.
2. Left sorted portion values will always be greater than right sorted portion. 
3. Hence if target < min value of left portion, then we have to move to the right.
4. If target > max value of right sorted portion, then move to the left

"""

class LeetCode33(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        l, r = 0, len(nums) - 1
        while l <= r:
            mid = (l + r) // 2
            if target == nums[mid]:
                return mid

            if nums[mid] >= nums[l]:
                # We are in left sorted portion
                # 1st condition in if is normal binary search condition
                # 2nd condition makes sure that if target < left element
                # then we have to move to the right because right sorted 
                # portion elements are always smaller than left elements
                if target > nums[mid] or target < nums[l]:
                    l = mid + 1
                else:
                    r = mid - 1
            else:
                # We are in right sorted portion
                # 1st condition in if is normal binary search condition
                # 2nd condition makes sure that if target > right element
                # then we have to move to the left because left sorted 
                # portion elements are always bigger than left elements
                if target < nums[mid] or target > nums[r]:
                    r = mid - 1
                else:
                    l = mid + 1
        
        return -1

   
        

