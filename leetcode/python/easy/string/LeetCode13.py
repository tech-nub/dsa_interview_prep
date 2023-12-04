"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/roman-to-integer
Time Complexity: O(n) where n is length of the string
Space Complexity: O(1)

ALGO:

1. As Roman numbers are generally written from left to right in decreasing order. e.g. VI is (5+1)=6
2. When Exception to this case happens, we need to subtract those numbers. e.g. IV is (5-1) = 4
3. From above 2 rules, add to the result if 1st rule applies and subtract if 2nd rule applies

"""

class LeetCode13(object):
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Create a map of characters and their values 
        romanMap = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        # Initialize the result variable
        result = 0
        for i in range(len(s)):
            # As Roman characters are written from left to right in decreasing order 
            # so, in case this is not true, it means left character is to be deducted 
            # from the right character. Hence compare each character to its right neighbour. 
            # If neighbour is bigger it means this character is to be subtracted. 
            # Edge case when we are looking at last character, so there will not be any i+1
            if i != len(s) - 1 and romanMap[s[i]] < romanMap[s[i + 1]]:
                result -= romanMap[s[i]]
            else:
                result += romanMap[s[i]]
        return result

