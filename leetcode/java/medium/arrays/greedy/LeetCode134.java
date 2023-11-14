"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/gas-station
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. Apply Greedy Approach. 
2. Sum of gas should be greater than Sum of cost for solution to exist.
3. Keep checking the diff of gas and cost for every index and keep adding it up.
4. If at some point this total becomes negative, it means that the position from where we started initially is not the solution.
5. Hence move the starting position to the next position from current position and reset the total to 0.

"""

class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // For solution to exist, sum of gas should be greater than sum of cost
        int sumGas = 0;
        int sumCost = 0;
        for (int g : gas) 
            sumGas+=g;

        for (int c : cost)
            sumCost+=c;

        if(sumGas < sumCost)
            return -1;

        // This is the running total of diff b/w gas and cost
        int gasCostTotal = 0;
        // This is the resultant position which we have to return
        int result = 0;

        for(int i = 0; i<gas.length;i++) {
            // At any given moment, if gasCostTotal < 0, reset it to 0. This means that
            // the starting position which we took initially did not work because we spent
            // more gas than we got. Increment the result to the next position of current i
            gasCostTotal +=(gas[i] - cost[i]);
            if(gasCostTotal < 0) {
                gasCostTotal = 0;
                result = i+1;
            }
        }
        return result;
    }   
}

