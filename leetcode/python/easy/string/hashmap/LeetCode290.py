"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/word-pattern
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. Use HashMaps for saving the mapping of character to word and vice versa.
2. As # of words in s should be equal to pattern length, so iterate through any of those and if mapping is already in HashMaps but it contradicts with current values, then return false.
3. If it is same or does not exist in maps, then add to the maps.

"""

class LeetCode290(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        sArray = s.split(" ")
        # # of strigs in s array should be same as length of pattern
        if len(sArray) != len(pattern):
            return False
        # Maps to save character to word and vice versa mappings
        charToWord = {}
        wordToChar = {}
        
        for c, w in zip(pattern, sArray):
            # If mapping of character to word or vice versa exists
            # but not equal to current values, then return false
            if c in charToWord and charToWord[c] != w:
                return False
            if w in wordToChar and wordToChar[w] != c:
                return False
            # Else add the mappings in both maps
            charToWord[c] = w
            wordToChar[w] = c
        return True
    
