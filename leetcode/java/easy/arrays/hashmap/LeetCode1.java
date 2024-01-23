"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/two-sum
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. Use a hashmap of Difference (target - 'number') and index of 'number'
2. Now iterate through all the numbers and if number exists in hashmap then it means we have found our solution. e.g. if target is 7 and our current number is 3 and if difference (7-3=4) exists in hashmap then we have found our number.

"""

class LeetCode1 {
    public int[] twoSum(int[] nums, int target) {
        // Map of Difference (target - 'number') and 
        // index of 'number'
        Map<Integer, Integer> indexDiff = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            // If number in map is same as (target - nums[i]) 
            // then we have found our solution
            if(indexDiff.containsKey(nums[i])) {
                return new int[] {indexDiff.get(nums[i]), i};
            }
            // Keep adding to the map the difference of the 
            // number and target and index
            indexDiff.put(target - nums[i], i);
        }
        // It should never reach here because there is exactly 
        // one solution as mentioned in the question
        return null;
    }
}

