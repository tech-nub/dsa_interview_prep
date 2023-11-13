"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/remove-duplicates-from-sorted-array
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach. One pointer at the index which needs to be filled and 2nd to iterate through the array.
2. If value at the 2nd pointer and the position before it are not same, it means we have to consider that value.
3. Insert value at r position to l position and move l and r. 
4. Only move l if the position has been filled

"""

public class LeetCode26 {
    public int removeDuplicates(int[] nums) {
        // 2 pointers approach. 1st pointer on the position to be
        // filled.
        // We started from 1 because 0th index will stay as it is
        int l = 1;

        // 2nd pointer r will move from 1st position which will keep
        // checking its value and the value at prev index
        for (int r = 1; r < nums.length; r++) {
            // Once we find unique value,
            // fill it with the value at r pointer
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                // move l pointer to next to be filled position
                l++;
            }
        }
        return l;
    }
}
