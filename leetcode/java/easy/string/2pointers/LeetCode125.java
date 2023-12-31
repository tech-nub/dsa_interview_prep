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

class LeetCode125 {
    public boolean isPalindrome(String s) {
        // 2 pointers. Take 2 pointers, 1 at beginning, another
        // at the end.
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            
            Character start = s.charAt(i);
            Character end = s.charAt(j);
            // Only do the comparison if character at pointers are
            // letter or digit else keep moving pointers
            if (!Character.isLetterOrDigit(start)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(end)) {
                j--;
                continue;
            }
            // If any of the characters does not match, return false
            if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
                return false;
            }
            
            i++;
            j--;    
        }
        return true;
    }
}

