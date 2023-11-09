/*
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/ 
*/

/* 
Problem Description -> https://leetcode.com/problems/merge-sorted-array
Time Complexity: O(m + n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach
2. As nums1 has m elements followed by n 0's at the end, hence 1st array should have the final result by replacing those 0's.
3. We start filling from the end because if we start filling from the start, we would replace the existing elements in nums1.
4. Take 1st pointer at the end of nums1 (not at last position but at the end of the legit values) and 2nd pointer at the end of nums2
5. ** Edge Case** : If any of the array is completely parsed, fill the rest of the values with the 2nd array's values
*/

public class LeetCode88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Pointer at the last valid index of 1st array
		int f = m - 1;
		// Pointer at the end of 2nd array
		int s = n - 1;

		// Start from last index of 1st array because those values
		// are all filled with
		// dummy 0. We started from end, because if we would have
		// started from
		// beginning, then we would have a risk of overriding the
		// existing legit values
		// of 1st array
		for (int i = m + n - 1; i >= 0; i--) {
			// As we have to fill it in non-decresing (ascending) order
			// and we are filling
			// from end to start so whichever is greater will be filled
			// first
			if (f >= 0 && s >= 0) {
				if (nums1[f] > nums2[s]) {
					nums1[i] = nums1[f];
					f--;
				} else {
					nums1[i] = nums2[s];
					s--;
				}
			}
			// If any of the values from 1st or 2nd array are taken
			// care, then we have to
			// fill the rest of the values. else if and else conditions
			// take care of that
			else if (f >= 0) {
				nums1[i] = nums1[f];
				f--;
			} else {
				nums1[i] = nums2[s];
				s--;
			}
		}
	}
}