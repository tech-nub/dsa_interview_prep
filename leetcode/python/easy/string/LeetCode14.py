"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/longest-common-prefix
Time Complexity: O(n * m) where n is length of strings and m is length of shortest string
Space Complexity: O(1)

ALGO:

1. Compare first string with every other string so 2 for loops
2. Also makes sure that you are not out of bounds as it is possible that 1st string is not the shortest string.

"""

class LeetCode14(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        res = ""
        # Compare first string with every other string
        for i in range(len(strs[0])):
            for s in strs:
                # It is possible that First string is not 
                # shortest so make sure i is in bound for s
                # or if chars dont match, we return the curr res
                if i == len(s) or s[i] != strs[0][i]:
                    return res
            # If char matches, keep updating the result
            res += strs[0][i]
        return res

