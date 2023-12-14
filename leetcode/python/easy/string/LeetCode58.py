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

class LeetCode58(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Iterate the string from the end
        ptr = len(s) - 1
        l = 0

        # As there can be spaces at the end, to skip them
        while s[ptr].isspace():
            ptr-=1

        # After all the spaces are skipped, start counting
        # length of string until we encounter another space
        while ptr >= 0:
            if s[ptr].isspace():
                return l
            # If no space found, keep moving pointer to left
            ptr-=1
            # Keep incrementing length of word
            l+=1
        
        return l
