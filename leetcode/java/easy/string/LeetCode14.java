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

class LeetCode14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder("");
        // Compare first string with every other string
        for(int i = 0; i < strs[0].length(); i++) {
            for(String s : strs) {
                // It is possible that First string is not 
                // shortest so make sure i is in bound for s
                // or if chars dont match, we return the curr res
                if(i == s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    return res.toString();
                }
            }
            // If char matches, keep updating the result
            res.append(strs[0].charAt(i));
        }
        return res.toString();
    }
}

