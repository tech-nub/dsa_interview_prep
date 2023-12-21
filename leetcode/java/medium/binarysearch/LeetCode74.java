"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/search-a-2d-matrix
Time Complexity: O(log(m * n))
Space Complexity: O(1)

ALGO:

1. Find the row first using binary search. If target is greater than last element of row, then it should lie in next row else if target is smaller than first element of row then it should lie in previous row
2. After finding a row, run normal binary search on the all the columns of that row.

"""

class LeetCode74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        // Find row first
        int l = 0, r = matrix.length - 1;
        int rows = matrix.length, cols = matrix[0].length;
        // If value is > last value of l row then we move l to next 
        // row, else we move r to prev row and if none of this matches 
        // i.e. value is in the current row, then break
        while(l <= r) {
            int row = (l + r)/2;
            if(target > matrix[row][cols -1])
                l++;
            else if(target < matrix[row][0])
                r--;
            else
                break;
        }
        // Just in case pointers crossed, then return false
        if (l > r)
            return false;
        // This is the row that was found after above binary search
        int row = (l + r)/2;
        l = 0;
        r = cols - 1;
        // Normal binary search in found row from 1st to last column
        while (l <= r) {
            int m = (l + r)/2;
            if (target > matrix[row][m])
                l = m + 1;
            else if (target < matrix[row][m])
                r = m - 1;
            else
                return true;
        }

        return false;
    }
}