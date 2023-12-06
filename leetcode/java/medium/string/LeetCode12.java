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

class LeetCode12 {
    public String intToRoman(int num) {
        // Create a list roman to integer mapping Pairs. 
        // Here we use list because we need to iterate from 
        // highest to lower number. In map we cannot do that. In this 
        // list, also add the exceptions like "IV" is 4 until 900 which 
        // are mentioned in problem statement
        List<Pair<String, Integer>> romanList = new ArrayList<>() { {
            add(new Pair<>("M", 1000)); add(new Pair<>("CM", 900));
            add(new Pair<>("D", 500)); add(new Pair<>("CD", 400));
            add(new Pair<>("C", 100)); add(new Pair<>("XC", 90));
            add(new Pair<>("L", 50)); add(new Pair<>("XL", 40));
            add(new Pair<>("X", 10)); add(new Pair<>("IX", 9));
            add(new Pair<>("V", 5)); add(new Pair<>("IV", 4));
            add(new Pair<>("I", 1));
        } };

        // We use StringBuilder instead of String because Strings are immutable
        // If we try to change any string, it will result into new String so
        // whenever we need to change the string a lot, use StringBuilder.
        StringBuilder res = new StringBuilder("");
        for (Pair<String, Integer> p : romanList) {
            // If number / Integer value of pair is > 0 it means we have 
            // Most Significant Bit. Depending on the count of MSB, we need 
            // to add those many number of Roman characters in result string
            // e.g. if count is 2 and divisor was 1000, then we add "MM"
            if (num / p.getValue() > 0) {
                int count = num /p.getValue();
                for (int i = 0; i<count;i++)
                    res.append(p.getKey());
                // Calculate the remaining portion to loop again
                num = num % p.getValue();
            }  
        }
            
        return res.toString();
    }
}