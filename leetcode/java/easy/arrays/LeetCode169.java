"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/majority-element
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. This solution makes use of the fact that majority element exists in the array. If it exists, it means its count will be greater than all other numbers combined (more than n/2). Hence if we assume any element to be majority element then if we cancel its count with other elements, it should still be more than 1. 
2. Iterate over all the elements and assume 1st element to be majority element.
3. If it matches with other elements, keep increasing the count and if it does not then keep decreasing it.
4. If count becomes 0 at any time then we have to assume that some other element is majority element and repeat the process.
5. At the end, the element for which count !=0 is our result.

There is another solution which makes use of Hashmap to count the # of occurance of a character. That solution takes O(n) space.

"""

class Solution {
    public int majorityElement(int[] nums) {
        // Initialize the count and res to 0
        int count = 0;
        int res = 0;

        // This prpblem states that there will always be a majority element in the array
        // So there will always be 1 number whose count will be greater than all other
        // numbers combined. Initially we can assume 1st number to be majority element and 
        // as we keep iterating through numbers, we increase a count variable if number is same 
        // as current majority element. If number is not same as current majority element then we
        // decrease the count. If count becomes 0, then we change the majority element to this element
        // because previous majority element count was all neutralized by presence of other elements 
        for(int num : nums) {
            // If count == 0, it means we can use the current number to be our result as all other numbers are cancelled
            if(count == 0) {
                res = num;
            }
            // If current res is same as this number then increase the count of it
            if(res == num) {
                count ++;
            } 
            // If not then reduce the count
            else {
                count--;
            }
        }
        return res;
    }
}