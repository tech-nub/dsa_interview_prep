"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
Time Complexity: O(log(n))
Space Complexity: O(1)

ALGO:

1. Binary search. This makes use of the fact that rotated sorted array will have 2 sorted portion, left sorted and right sorted.
2. Left sorted portion values will always be greater than right sorted portion hence we will find minimum value in right sorted portion.
3. Run binary search, when we find mid value > right, it means we are in left sorted portion so move to the right else move left.
4. On each iteration, keep updating the min value in a variable.

"""
class LeetCode153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        // Rotated sorted arrat will have left sorted portion
        // and right sorted portion. Right sorted portion will
        // always have min value
        while (l <= r) {
            int m = (l + r)/2;
            // Keep updating minimum value
            min = Math.min(min, nums[m]);
            // If mid value is > r value then we are in 
            // left sorted portion, but min value will be 
            // in the right sorted portion always so move right
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                // It means we are already in the right sorted
                // portion hence move to the left in right portion
                r = m - 1;
            }
        }
        return Math.min(min, nums[l]);
    }
}
