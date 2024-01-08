"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/3sum
Time Complexity: O(n^2)
Space Complexity: O(1)

ALGO:

1. Fix one element at a time and try to find other 2 numbers using 2 pointers l and r.
2. Sort the array first because array can contain duplicate numbers. Sorting would help to remove duplicates easily as we can check consecutive elements.
3. keep adding the matches to result set as we have to find all the matching combinations.


"""
class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Sort the array because we want to get rid of duplicate numbers
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++) {
            if(i ==0 || (i > 0 && nums[i] != nums[i-1])) {
                // Sum of all 3 nums should be 0 hence sum of other 2 numbers 
                // should be 0 minus this number
                int target = 0 - nums[i];
                // Start 2 pointer approach, where l is at the 1st position of 
                // the remaining array and r is at the end of remaining array
                int l = i+1;
                int r = nums.length - 1;
                while(l < r) {
                    // If we found the sum, then save it and move l and r until
                    // we get rid of duplicate numbers. If sum > target means
                    // we need to bring r closer to l else move l closer to r
                    if (nums[l] + nums[r] == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]); temp.add(nums[l]); temp.add(nums[r]);
                        res.add(temp);
                        while(l < r && nums[l] == nums[l+1])
                            l++;
                        while(l < r && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] > target)
                        r--;
                    else
                        l++;
                }}}
        return res;
    }}

    