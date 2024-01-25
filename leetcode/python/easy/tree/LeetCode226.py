"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/invert-binary-tree

ALGO:

1. Left node should be put on right and right node should be put on left and this should be done recursively until the leaf node.
2. Hence we will use recursion to solve this. 
3. Save left node in a temp variable and swap left node with right node.
4. Next swap right node with temp node.

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode226(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        # Base case
        if not root : 
            return None
        # Save in temp so not overridden during swap
        temp = root.left
        # Assign left with DFS of right
        root.left = self.invertTree(root.right)
        # Assign right with dfs of left/temp
        root.right = self.invertTree(temp)

        return root

