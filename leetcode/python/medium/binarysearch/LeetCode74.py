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

class LeetCode74(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # Find row first
        ROWS, COLS = len(matrix), len(matrix[0])

        l, r = 0, ROWS - 1
        # If value is > last value of l row then we move l to next 
        # row, else we move r to prev row and if none of this matches 
        # i.e. value is in the current row, then break
        while l <= r:
            row = (l + r) // 2
            if target > matrix[row][-1]:
                l = row + 1
            elif target < matrix[row][0]:
                r = row - 1
            else:
                break
        # Just in case pointers crossed, then return false
        if not (l <= r):
            return False
        # This is the row that was found after above binary search
        row = (l + r) // 2
        l, r = 0, COLS - 1
        # Normal binary search in found row from 1st to last column
        while l <= r:
            m = (l + r) // 2
            if target > matrix[row][m]:
                l = m + 1
            elif target < matrix[row][m]:
                r = m - 1
            else:
                return True
        return False 
