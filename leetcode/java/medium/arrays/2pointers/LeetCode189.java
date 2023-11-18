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

class LeetCode189 {
    public void rotate(int[] nums, int k) {
        // 2 pointer technique
        // Reverse the whole array
        int l = 0;
        int r = nums.length - 1;
        // [1,2,3,4,5,6,7] --> [7,6,5,4,3,2,1]
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
        // Reverse the first k part e.g. if k = 3
        // [7,6,5,4,3,2,1] --> [5,6,7,4,3,2,1]
        l = 0;
        r = (k % nums.length) -1;
        while(l<r) {
            swap(nums, l, r);
            l++;
            r--;
        }
        // Reverse rest of the portion if k = 3
        // [5,7,6,4,3,2,1] --> [5,6,7,1,2,3,4]
        l = (k % nums.length);
        r = nums.length - 1;
        while(l<r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    // Method to swap 2 numbers in an array
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}