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
    Boolean reverse = false;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(root , res);
        return res;
    }

    public void level(TreeNode root , List<List<Integer>> res){
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            List<Integer> curr = new ArrayList<>();

            for(int i = 0 ; i < size; i++){
                TreeNode node = queue.poll();
                if(reverse) curr.add(0 , node.val);
                else curr.add(node.val);

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(reverse) reverse = false;
            else reverse = true;
            res.add(curr);
        }
    }
}