"""
Github -> https://github.com/tech-nub/dsa_interview_prep
Instagram -> https://www.instagram.com/tech_nub/
"""

""" 

Problem Description -> https://leetcode.com/problems/symmetric-tree

ALGO:

1. Trees are symmetrical if left and right trees are mirror images of each other.
2. So to check this, we need to check whether left node of left tree matches with right node of right tree and we have to do this recursively.
3. If both nodes are null, means they are matching and hence we return true.
4. Also, values of both the nodes should match if they are not null and recursively their left and right node values should also match.
5. If one of the nodes is null, then clearly they are not matching and hence return false.

"""

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode101(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        # Call dfs with left and right node
        return self.dfs(root.left, root.right)
    
    def dfs(self, s, t):
        # If both are null, means matching hence false
        if not t and not s:
            return True
        # If one of them is null, means not matching hence false
        if not s or not t:
            return False
        # both values should be equal and left should match to right 
        # Do this recursively
        return s.val == t.val and self.dfs(s.left, t.right) and self.dfs(s.right, t.left)

