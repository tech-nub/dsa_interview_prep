"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/merge-sorted-array
Time Complexity: O(m + n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach
2. As nums1 has m elements followed by n 0's at the end, hence 1st array should have the final result by replacing those 0's.
3. We start filling from the end because if we start filling from the start, we would replace the existing elements in nums1.
4. Take 1st pointer at the end of nums1 (not at last position but at the end of the legit values) and 2nd pointer at the end of nums2
5. ** Edge Case** : If any of the array is completely parsed, fill the rest of the values with the 2nd array's values

"""

class LeetCode88(object):
    def merge(self, nums1, m, nums2, n):
        """
        Start from last index of nums1 because those values
		are all filled with dummy 0. We started from end, because
		if we would have started from beginning, then we would
		have a risk of overriding the existing legit values of nums1
        """
        while m > 0 and n > 0:
            if nums1[m-1] >= nums2[n-1]:
                nums1[m+n-1] = nums1[m-1]
                m-=1
            else:
                nums1[m+n-1] = nums2[n-1]
                n-=1
        # If there are still some values left in nums2, fill them in nums1
        while n > 0:
            nums1[m+n-1] = nums2[n-1]
            n-=1