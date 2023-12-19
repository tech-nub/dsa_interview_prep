"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/search-insert-position
Time Complexity: O(log(n))
Space Complexity: O(1)

ALGO:

1. As soon as you see a sorted array and we have to find a number, there is no better algo than binary search.
2. In binary search, search area keeps getting half at every iteration and we keep on movinng 2 pointers.
3. If search value is less than the current value, then move right pointer to the left.
4. else move left pointer to the left


"""

class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        // Binary search has 2 pointers initially at 
        // start and end positions of array
        int l = 0;
        int r = nums.length -1;
        // Iterate until l and r cross each other
        while ( l <= r) {
            int m = (r+l)/2;
            // If mid point value is equal to target then 
            // this is our answer
            if(nums[m] == target)
                return m;
            // else if target is less then move right pointer
            // to the left
            else if (target < nums[m])
                r = m - 1;
            // else move left pointer to the right 
            else 
                l = m + 1;
        }
        // At the end l will be at the desired position
        return l;
    }
}