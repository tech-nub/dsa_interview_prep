"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/length-of-last-word
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. From the end keep skipping the spaces as there can be spaces after the last word.
2. Once we encounter first character, keep iterating until we find next space. In this step, keep counting the number of non-space characters. Which is our result.

"""

class LeetCode58 {
    public int lengthOfLastWord(String s) {
        // Iterate the string from the end
        int pointer = s.length() - 1;
        int l = 0; // Initial length of the string

        // As there can be spaces at the end, to skip them
        while(s.charAt(pointer) == ' ') {
            pointer = pointer - 1;
        }

        // After all the spaces are skipped, start counting
        // length of string until we encounter another space
        while(pointer >= 0) {
            if(s.charAt(pointer) == ' ') {
                return l;
            }
            // If no space found, keep moving pointer to left
            pointer --;
            // Keep incrementing length of word
            l ++;
        }

        return l;
    }
}