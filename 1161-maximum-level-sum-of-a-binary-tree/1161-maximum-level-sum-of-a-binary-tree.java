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
    int max; int level; int currLevel;
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        max = root.val;
        level = 1;
        currLevel = 1;

        while(!queue.isEmpty()){
            int currSum = 0;
            int size = queue.size();

            for(int i = 0; i < size; i++){

                TreeNode node1 = queue.poll();

                currSum += node1.val;

                if(node1.left != null)
                    queue.offer(node1.left);

                if(node1.right != null)
                    queue.offer(node1.right);

            }
            if(currSum > max){
                max = currSum;
                level = currLevel;
            }
            currLevel++;
            

        }

        return level;
    }
}