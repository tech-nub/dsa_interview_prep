"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/valid-palindrome
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. 2 Pointers approach. Keep 1st pointer at the beginning and another at the end.
2. Only move pointers if characters at each of them match or they are other than letter or digit (space or any other character).
3. If at any point we find a mismatch, return false. If we reach at the end, then return true.

"""

class LeetCode125(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # 2 pointers. Take 2 pointers, 1 at beginning, 
        # another at the end.
        i, j = 0, len(s) - 1
        while i < j:
            a = s[i]
            # Only do the comparison if character at pointers are
            # letter or digit else keep moving pointers
            if not a.isalpha() and not a.isdigit():
                i+=1
                continue
            b = s[j]
            if not b.isalpha() and not b.isdigit():
                j-=1
                continue
            # If any of the characters does not match, return false
            if s[i].lower() != s[j].lower():
                return False
            i +=1
            j -=1
        
        return True
    
