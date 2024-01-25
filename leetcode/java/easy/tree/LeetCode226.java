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
class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        // Base case
        if (root == null) {
            return null;
        }

        // Save in temp so not overridden during swap
        TreeNode temp = root.left;
        // Assign left with DFS of right
        root.left = invertTree(root.right);
        // Assign right with dfs of left/temp
        root.right = invertTree(temp);

        return root;
    }
}

