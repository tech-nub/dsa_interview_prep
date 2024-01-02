"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/is-subsequence
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach one at the beginning of each string.
2. Move both pointers if characters match.
3. Move only t string pointer, if characters do not match.
4. At the end our goal is that everything in s is in t in the same order. If l has crossed the length of the string s, then we found our result and hence return true.

"""

cclass LeetCode392(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # Take 2 pointers, one at the beginning \
        # of each string 
        l, r = 0, 0
        while l < len(s) and r < len(t):
            # If characters at both pointers match, then move
            # both pointers
            if s[l] == t[r]:
                l+=1
                r+=1
            else:
                # else move only t string pointer until we find
                # one matching character
                r+=1
        # If l crosses the last character of s, it means we were 
        # able to match everything from s against t. Return true
        if l >= len(s):
            return True
        # Else return false
        return False

