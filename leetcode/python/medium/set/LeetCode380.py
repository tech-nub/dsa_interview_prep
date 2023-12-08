"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/insert-delete-getrandom-o1
Time Complexity: O(1)
Space Complexity: O(n)

ALGO:

1. Use 1 map and 1 list to implement O(1) for all operation. 
2. In map, keep a record of value and index where value is being inserted in list.
3. Removal is tricky. Because removing from middle will cause list elements to shift, so here is how we will remove : 
(i) move the number from last index to the removed position and update the map. 
(ii) and then remove from the end of the list which does not need shifting of elements
4. We can get random from the list using the size of the list

"""

def __init__(self):
        self.dict = {}
        self.list = []

    def insert(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val in self.dict:
            return False
        # Set the value in map with index
        self.dict[val] = len(self.list)
        # Add the value to the list
        self.list.append(val)
        return True

    def remove(self, val):
        """
        :type val: int
        :rtype: bool
        """
        if val not in self.dict:
            return False
        # Find the index of element to be removed and last element in the list
        idx, last_element = self.dict[val], self.list[-1]
        # Copy last element on the index of element to be removed and change its index in map
        self.list[idx], self.dict[last_element] = last_element, idx
        # Remove last element from list as it is duplicate now
        self.list.pop()
        # delete the value from map also
        del self.dict[val]
        return True

    def getRandom(self):
        """
        :rtype: int
        """
        return choice(self.list)