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

class LeetCode13 {
    public int romanToInt(String s) {
        // Create a map of characters and their values 
        Map<Character, Integer> romanMap = new HashMap<>()
        {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        // Initialize the result variable
        int result = 0;

        // Iterate through string from left to right        
        for(int i = 0; i<s.length(); i++) {
            // As Roman characters are written from left to right in decreasing order 
            // so, in case this is not true, it means left character is to be deducted 
            // from the right character. Hence compare each character to its right neighbour. 
            // If neighbour is bigger it means this character is to be subtracted. 
            // Edge case when we are looking at last character, so there will not be any i+1
            if(i != s.length() - 1 && romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i+1))) {
                result-=romanMap.get(s.charAt(i));
            } else {
                result+=romanMap.get(s.charAt(i));
            }
        }

        return result;
    }
}
