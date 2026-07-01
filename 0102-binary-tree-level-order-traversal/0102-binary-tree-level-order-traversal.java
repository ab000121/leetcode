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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(root, res);
        return res;
    }

    public void levelOrder(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode node1 = queue.poll();

                level.add(node1.val);

                if(node1.left != null)
                    queue.offer(node1.left);

                if(node1.right != null)
                    queue.offer(node1.right);
            }

            res.add(level);
        }
    }
}