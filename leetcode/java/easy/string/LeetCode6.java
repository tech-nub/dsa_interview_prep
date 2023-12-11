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


class LeetCode6 {
    public String convert(String s, int numRows) {
        // If number of rows is 1, there will not be any zigzag
        if(numRows == 1) {
            return s;
        }


        // Use stringbuilder to form result string as it is efficient 
        // when doing many string manipulations
        StringBuilder res = new StringBuilder("");

        // Move through each row. Distance between 2 characters is observed
        // as a formula in zigzag which is 2 * (numRows - 1), so if numRows = 4
        // then 2nd character of 1st row will be 2 *(4-1) = 6 steps apart
        // This rule applies only to 1st and last rows. For the middle rows, 
        // this formula becomes 2 * (numRows - 1 - rowIndex), so for 2nd row 
        // (index 1) value will be 2 * (4 - 1 - 1) = 4 and so on.
        for(int r = 0; r<numRows;r++) {
            int distance = 2 * (numRows - 1);
            for(int i = r; i<s.length(); i+=distance) {
                // First character will always be the character at row number
                // because characters are first written vertically
                res.append(s.charAt(i) + "");
                // As explained above, if row is not 1st or last, we will need to 
                // use another formula. Here we are checking whether that index is 
                // out of range of input string
                if(r > 0 && r < numRows - 1 && (i + distance - 2*r) < s.length()) {
                    res.append(s.charAt(i + distance - 2*r) + "");
                }
            }
        }
        return res.toString();
    }
}