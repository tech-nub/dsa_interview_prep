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
class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        // Call dfs with left and right node
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        // If both are null, means matching hence false
        if(p == null && q == null) {
            return true;
        }

        // If one of them is null, means not matching hence false
        if(p == null || q == null) {
            return false;
        }

        // both values should be equal and left should match to right 
        // Do this recursively
        return p.val == q.val && dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}