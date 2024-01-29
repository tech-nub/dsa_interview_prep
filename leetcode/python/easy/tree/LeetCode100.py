"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/same-tree

ALGO:

1. For trees to be same, each node's value and position should be same and trees should have same no. of nodes.
2. Check for the opposite conditions first i.e. if values are not equal or one of the nodes is null, then return false.
3. Do this recursively for all the left and right subtrees.


# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
"""
class LeetCode100(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        # Base condition. If we have reached null for both
        # then return true
        if not p and not q:
            return True
        # If we have reached null only for 1 then return false
        if not p or not q:
            return False
        # If value at a node is not equal, then return false
        if p.val != q.val:
            return False
        # Do the check recursively for left && right
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)