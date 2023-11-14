"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach. One pointer at the index which needs to be filled and 2nd to iterate through the array.
2. If value at r and l are same and we already have not considered same value twice, then consider this value.
3. If values at l and r are not same, it means we have got next unique value to consider and hence reset the count to 1.
4. Only move l before filling the position.

"""

class LeetCode80 {
    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        // Initialize count with 1 as l is at 1st index 
        // as we are considering this value no matter what
        int count = 1;
        while(r < nums.length && l < nums.length) {
            // If num at l and r are equal AND count < 2, then we have to take value of r
            if(count < 2 && nums[l] ==  nums[r]) {
                l++;
                nums[l] = nums[r];              
                count++;
            }
            // Once we find next unique value, it is time to move our l pointer and 
            // take r value and reset the count to 1 as this is the 1st value of that 
            // particular num we are taking. Keep moving r as usual
            else if(nums[l] != nums[r]) {
                l++;
                nums[l] = nums[r];
                count = 1;
            }
            // Case where count >=2 and nums[l] ==  nums[r], we just have to move r pointer 
            // because we have already got 2 occurances of that number and we do not want more 
            // until we have r at a unique value, so no need to write that case specifically 
            // as we are moving r pointer with every iteration anyway
            
            // Keep moving r as usual with every iteration
            r++;
        }

        // At the end, l pointer will be at the last unique index which we have filled. 
        // As l pointer is 0 based, so we need to return l+1
        return l+1;
    }
}
