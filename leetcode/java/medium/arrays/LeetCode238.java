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

class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int runningProductBefore = 1;

        // Save in the result array all the products before i
        for (int i = 0; i < nums.length; i++) {
            res[i] = runningProductBefore;
            runningProductBefore = runningProductBefore * nums[i];
        }

        int runningProductAfter = 1;
        // Save in result array product before num * product after num
        for (int i = nums.length - 1; i >= 0; i--) {
            // final current index value will be running product after 
            // current index multiplied with current value at index i 
            // in res array which was precomputed earlier
            res[i] = runningProductAfter * res[i];

            // Running product after will be updated with addition of 
            // current number in original array at index i
            runningProductAfter = runningProductAfter * nums[i];
        }

        return res;
    }
}