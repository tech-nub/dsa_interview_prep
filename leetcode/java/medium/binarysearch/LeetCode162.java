"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/find-peak-element
Time Complexity: O(log(n))
Space Complexity: O(1)

ALGO:

1. Because we have to get the solution in log(n) runtime, so we have to go with binary search.
2. Peak element can be corner element as well if its another neigbour is smaller than it.
3. In binary search, if middle element is greater than its left and right neighbour then that is our result.
4. Else whichever side is greater than middle element, we will find the result on that side and move the pointers to that side of middle.

"""

class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        // Move to the side, whichever is greater than mid because
        // peak will only be where we have greater value
        while (l <= r) {
            int m = (l + r)/2;
            // If left neignour is greater, then move right to left
            if (m > 0 && nums[m] < nums[m - 1]) 
                r = m - 1;
            // If right neighbour is greater, then move left to right
            else if (m < nums.length - 1 && nums[m] < nums[m+1])
                l = m + 1;
            // If mid is > left & right, we founf the result
            else
                return m;
        }

        return -1;
    }
}

