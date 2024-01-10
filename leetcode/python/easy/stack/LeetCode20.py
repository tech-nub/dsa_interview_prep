"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/valid-parentheses
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. If an opening bracket comes, push it to the stack.
2. If closing bracket comes, then we should have a corresponding opening bracket in the stack. If it exists, pop it from the stack, if it does not, means no valid combinations and hence return false.
3. At the end, stack should be empty because all opening brackets should match with closing brackets.


"""
class LeetCode20(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # Keep a map of valid pairs
        map = {")": "(", "]": "[", "}": "{"}
        stack = []

        for c in s:
            # Check the key in map, means check if it
            # is a closed bracket, if not then push to the staack
            if c not in map:
                stack.append(c)
                continue
            # If closed bracket, then open should exist in map, else
            # return false
            if not stack or stack[-1] != map[c]:
                return False
            # else pop from the stack if match is found
            stack.pop()
        # stack should be empty at the end
        return not stack

