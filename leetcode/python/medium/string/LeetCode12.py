"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/integer-to-roman
Time Complexity: O(n) where n is length of the string
Space Complexity: O(1)

ALGO:

1. As Roman numbers are generally written from left to right in decreasing order. e.g. VI is (5+1)=6
2. Exception to this case happens, when we need to subtract those numbers. e.g. IV is (5-1) = 4
3. We will keep on doing integer division from highest roman value up until lowest to find out most significant bit.
4. Once we have MSB, depending upon the roman equivalent with which we had divided, as those many Roman characters to the resultant string.
5. Find out the remainder and repeat the steps 3 and 4 to find next MSB.

"""

class LeetCode12(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        # Create a list roman to integer mapping Pairs. 
        # Here we use list because we need to iterate from 
        # highest to lower number. In map we cannot do that. In this 
        # list, also add the exceptions like "IV" is 4 until 900 which 
        # are mentioned in problem statement
        romanList = [ 
            ["M", 1000], ["CM", 900], ["D", 500], ["CD", 400],
            ["C", 100], ["XC", 90], ["L", 50], ["XL", 40],
            ["X", 10], ["IX", 9], ["V", 5], ["IV", 4],
            ["I", 1],
        ]
        res = ""
        for char, val in romanList:
            # If number / Integer value of pair is > 0 it means we have 
            # Most Significant Bit. Depending on the count of MSB, we need 
            # to add those many number of Roman characters in result string
            # e.g. if count is 2 and divisor was 1000, then we add "MM"
            if num // val:
                count = num // val
                res += char * count
                # Calculate the remaining portion to loop again
                num = num % val
        return res

