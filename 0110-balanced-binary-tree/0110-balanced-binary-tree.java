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
class Solution {
    public boolean isBalanced(TreeNode root) {
        // if(root == null) return true;
        
        return height(root) != -1;
    }

    public int height(TreeNode node){
        if(node == null) return 0;

        int lHeight = height(node.left);

        if(lHeight == -1)return -1;

        int rHeight = height(node.right);

        if(rHeight == -1) return -1;

        if(Math.abs(lHeight - rHeight) > 1) return -1;

        return Math.max(lHeight , rHeight) + 1;
    }
}