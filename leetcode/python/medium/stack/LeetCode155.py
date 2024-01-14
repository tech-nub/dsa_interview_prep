"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/min-stack
Time Complexity: O(1)
Space Complexity: O(n)

ALGO:

1. We will use 2 stacks, one for storing normally and another to track minimum value.
2. When we push to normal stack, we will check whether minStack is empty. If it is empty, then blindly push the value to minStack also
3. If minStack is not empty, then check if the value to be pushed is smaller or larger than current minimum value (top of minStack).
4. If minStack current minimum is larger than value to be pushed, then push the value.
5. If minStack current minumum is smaller than value to be pushed, then push the same minStack current minimum again to minStack. This is because we cannot miss a value. 

"""
class LeetCode155(object):
    def __init__(self):
        # Use 2 stacks, one normal and another which
        # only tracks minimum value
        self.stack = []
        self.minStack = []

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        # Push to stack as normal but push to minStack the minimum 
        # of minStack's top val and current val
        self.stack.append(val)
        val = min(val, self.minStack[-1] if self.minStack else val)
        self.minStack.append(val)
        
    def pop(self):
        """
        :rtype: None
        """
        self.stack.pop()
        self.minStack.pop()

    def top(self):
        """
        :rtype: int
        """
        return self.stack[-1]

    def getMin(self):
        """
        :rtype: int
        """
        return self.minStack[-1]