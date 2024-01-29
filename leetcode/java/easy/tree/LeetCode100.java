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

"""

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class LeetCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base condition. If we have reached null for both
        // then return true
        if(p== null && q == null) {
            return true;
        }
        // If we have reached null only for 1 then return false
        if(p == null || q == null) {
            return false;
        }
        // If value at a node is not equal, then return false
        if(p.val != q.val) {
            return false;
        }
        // Do the check recursively for left && right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

