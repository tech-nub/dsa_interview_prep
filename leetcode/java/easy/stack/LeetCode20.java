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
class LeetCode20 {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        // Opening bracket should come before closing bracket
        // so if closing bracket comes, we should have a
        // corresponding opening bracket already on stack. If
        // opening bracket is encountered first, push it to stack 
        for(char c : s.toCharArray()) {
            if(c == '}' || c == ']' || c == ')') {
                if(st.isEmpty()) {
                    return false;
                } else if (c == '}' && st.peek() != '{'){
                    return false;
                } else if (c == ']' && st.peek() != '[') {
                    return false;
                } else if(c == ')' && st.peek() != '(') {
                    return false;
                } else {
                    st.pop();
                }                
            } else {
                st.push(c);
            }
        }
        // This is an edge case, at the end stack should be empty
        return st.isEmpty() ? true : false;
    }
}

