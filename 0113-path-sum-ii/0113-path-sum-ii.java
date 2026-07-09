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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        hasPath(root , targetSum , res , new ArrayList<>());
        return res;
    }

    public void hasPath(TreeNode node , int targetSum , List<List<Integer>> res , List<Integer> curr){
        if(node == null) return;

        curr.add(node.val);

        if(node.left == null && node.right == null && targetSum == node.val) res.add(new ArrayList<>(curr));

        
        hasPath(node.left , targetSum - node.val , res ,curr);
        hasPath(node.right , targetSum - node.val , res ,curr);
        curr.remove(curr.size() - 1);
    }
}