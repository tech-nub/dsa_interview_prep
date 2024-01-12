"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/evaluate-reverse-polish-notation
Time Complexity: O(n)
Space Complexity: O(n)

ALGO:

1. In RPN, operators like +, -, /, * come after operands (numbers) on which operation is to be performed.
2. Hence we will need to wait for the operator to come and until then we will have to save the operands in the same order when they arrived.
3. Use stack to keep the operands until operator arrives. We did not use queue, because if operator comes after 2 numbers, then it is fine but if it comes after 3 numbers, then operation has to be performed on recent 2 operands and 3rd has to wait until another operator arrives. e.g. ["4","13","5","/","+"]. Here / has to be done on 13 and 5 and result of that to be added to 4. 

"""
class LeetCode150(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        # In RPM, operator comes after operands, so
        # we will use a stack and as soon as we encounter
        # an operator, we will pull from stack and calculate
        # using the operator and push result to stack. At the
        # end we will have the result in the stack
        stack = []
        for c in tokens:
            if c == "+":
                stack.append(stack.pop() + stack.pop())
            elif c == "-":
                a, b = stack.pop(), stack.pop()
                stack.append(b - a)
            elif c == "*":
                stack.append(stack.pop() * stack.pop())
            elif c == "/":
                a, b = stack.pop(), stack.pop()
                stack.append(int(float(b) / a))
            else:
                stack.append(int(c))
        return stack[0]
    
