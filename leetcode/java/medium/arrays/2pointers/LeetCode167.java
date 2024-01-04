"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach one at the beginning of array and another at the end.
2. This is kind of a modified binary search, move right pointer to the left if sum is greater than target, else move left pointer to the right if sum is less than target.
3. Return indices if sum = target

"""

class LeetCode167 {
    public int[] twoSum(int[] numbers, int target) {
        // Take 2 pointers, 1 at the beginning and another
        // at the end of array
        int l = 0;
        int r = numbers.length - 1;

        while(l < r) {
            // If numbers at both pointers add to target then
            // return the indices
            if(numbers[l] + numbers[r] == target) {
                return new int[] {l + 1, r + 1};
            }
            // If they are greater than target then move right
            // pointer to left as this will reduce sum as array 
            // is sorted. Do opposite if they are less than target
            if(numbers[l] + numbers[r] > target) {
                r --;
            } else if(numbers[l] + numbers[r] < target) {
                l++;
            }
            
        }

        return null;
    }
}