"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/ransom-note
Time Complexity: O(m + n)
Space Complexity: O(n)

ALGO:

1. Take a hashmap or array to count each character in magazine.
2. Iterate through ransomNote string and reduce the count corresponding to current character from array.
3. If at any point, count becomes negative, it means there are some characters in ransomnote  which do not have the same frequency in magazine, hence return false.

"""

class LeetCode383(object):
    def canConstruct(self, ransomNote, magazine):
        """
        :type ransomNote: str
        :type magazine: str
        :rtype: bool
        """
        # Map of character and its frequency
        freq = {}
        
        for c in magazine:
            freq[c] = 1 + freq.get(c, 0)
        
        # Iterate through ransomNote and keep reducing count of 
        # characters which we earlier calculated. If at any point
        # count of any character becomes less than 0 it means we
        # cannot build ransomnote from magazine
        for ch in ransomNote:
            if freq.get(ch) <= 0:
                return False
            freq[ch] = freq.get(ch) - 1

        return True

