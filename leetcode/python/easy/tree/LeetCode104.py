"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/maximum-depth-of-binary-tree

ALGO:

1. Depth of tree is the # of max nodes from root to any of the leaf nodes.
2. This solution is recursive. If we reach to the null node, we return 0.
3. Else we recursively go to left and right subtrees and find the max from there and add 1 to it for the current node.

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode104(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        # Base condition if we hve reached null, then we return 0
        if not root:
            return 0
        
        # Depth is 1 + Max of left and right subtree depths recursively
        # because 1 is for current node
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

