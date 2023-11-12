"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/remove-element
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach. One pointer at the index which needs to be filled and 2nd to iterate through the array.
2. If a needed value is found at 2nd pointer, insert it at the position of 1st pointer and move this pointer forward. 
3. Else move only the 2nd pointer forward to check the next value

"""

class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        // This is the position which needs to be filled
        int ptr = 0;

        // Loop through the entire array
        for(int i = 0; i< nums.length; i++) {
            // If current number is not we want to remove, 
            // then we can consider it in the final array and 
            // add it to the current position ptr and increment 
            // ptr to fill the next position
            if(nums[i] != val) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }

        // Once all the numbers have been iterated through, ptr 
        // will be at 1 position forward to last filled position 
        // and hence ptr will actually signify the length of the 
        //good array instead of index
        return ptr;
    }
}
