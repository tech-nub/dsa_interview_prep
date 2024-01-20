"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/valid-anagram
Time Complexity: O(m + n)
Space Complexity: O(n)

ALGO:

1. Take a hashmap/array to count each character in 1st string.
2. Now iterate in 2nd string and check if we have same characters and count in 2nd string. If not return false, else return true.

"""

class LeetCode242(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # To be anagram, length of the Strings should be same
        if len(s) != len(t):
            return False

        # Take 2 hashmaps for each string characters count
        countS, countT = {}, {}

        for i in range(len(s)):
            # keep counting s and t characters frequencies
            countS[s[i]] = 1 + countS.get(s[i], 0)
            countT[t[i]] = 1 + countT.get(t[i], 0)
        # At the end if 2 hashmaps are same, then return true
        return countS == countT

