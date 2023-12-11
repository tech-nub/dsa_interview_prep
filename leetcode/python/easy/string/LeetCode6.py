"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/

Problem Description -> https://leetcode.com/problems/zigzag-conversion
Time Complexity: O(m * n) where m = # of rows and n is length of String
Space Complexity: O(1)

ALGO:

1. For 1st and last row, Distance between 2 characters is observed as a formula in zigzag which is 2 * (numRows - 1), so if numRows = 4 then 2nd character of 1st row will be 2 *(4-1) = 6 steps apart
2. For the middle rows, this formula becomes 2 * (numRows - 1 - rowIndex), so for 2nd row (index 1) value will be 2 * (4 - 1 - 1) = 4 and so on.

"""


class LeetCode6(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        # If number of rows is 1, there will not be any zigzag
        if numRows == 1:
            return s
        
        res = ""

        # Move through each row. Distance between 2 characters is observed
        # as a formula in zigzag which is 2 * (numRows - 1), so if numRows = 4
        # then 2nd character of 1st row will be 2 *(4-1) = 6 steps apart
        # This rule applies only to 1st and last rows. For the middle rows, 
        # this formula becomes 2 * (numRows - 1 - rowIndex), so for 2nd row 
        # (index 1) value will be 2 * (4 - 1 - 1) = 4 and so on.
        for r in range(numRows):
            distance = 2 * (numRows - 1)
            for i in range(r, len(s), distance) :
                # First character will always be the character at row number
                # because characters are first written vertically
                res+=s[i]
                # As explained above, if row is not 1st or last, we will need to 
                # use another formula. Here we are checking whether that index is 
                # out of range of input string
                if r > 0 and r < numRows-1 and i+distance - 2*r < len(s):
                    res+=s[i + distance - 2*r]
        
        return res
    
    