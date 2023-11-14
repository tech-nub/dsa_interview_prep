"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/candy
Time Complexity: O(n)
Space Complexity: O(1)

ALGO:

1. In the first pass, go from left to right.
2. If current rating is more than left neighbour, then increase the # of candies for this child.
3. We will also have to do a second pass because if after the first pass, neigbour on the left has better rating than current child, then candies need to be increased for left neigbour and hence we will have to go back.
4. So, in 2nd pass, go from right to left and increase candies if and only if rating is higher than right neigbour and candies are not already higher.

"""

class LeetCode135(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        # Initialize candy array with 1 value at every index
        candy = [1] * len(ratings)

        # Forward pass to compare current position to the left
        # position. If rating is greater, then increase # of candies
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i-1] :
                candy[i] = 1 + candy[i-1]
        
        # Reverse Pass to compare current with right neigbour. Here we also
        # need to check whether candies are <= if rating is greater. Only in
        # this case, we need to increase candies
        for i in range(len(ratings)-2, -1, -1):
            if ratings[i] > ratings[i+1] and candy[i] <= candy[i+1] :
                candy[i] = 1 + candy[i+1]

        # Take sum of all candies and return
        return sum(candy)