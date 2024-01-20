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

class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        // To be anagram, length of the Strings should be same
        if(s.length() != t.length()) {
            return false;
        }
        // As Strings only contain small letters which are 26 (a-z), 
        // so we use an array to keep the count of each digit
        int[] alphabetsCount = new int[26];
        for(char c : s.toCharArray()) {
            alphabetsCount[c - 'a']++;            
        }

        // check if we have same characters count in 2nd String
        for(char c : t.toCharArray()) {
            alphabetsCount[c - 'a']--;
            // If character count becomes < 0, return false
            if(alphabetsCount[c - 'a'] < 0) {
                return false;
            }
        }

        // If we didn't return false, return true.
        return true;
    }
}

