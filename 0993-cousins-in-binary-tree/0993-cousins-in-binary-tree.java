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
    class Triplet{
        TreeNode parent;
        TreeNode node;
        int level;
        public Triplet(TreeNode parent,TreeNode node,int level){
            this.parent = parent;
            this.node = node;
            this.level = level;
        }
    }

    private Triplet forX = null , forY = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Triplet> queue = new LinkedList<>();
        queue.offer(new Triplet(null,root,1));

        while(!queue.isEmpty() && forX == null || forY == null){
            Triplet triplet = queue.poll();
            if(triplet.node.val == x) forX = triplet;

            else if(triplet.node.val == y) forY = triplet;

            if(triplet.node.left != null) queue.offer(new Triplet(triplet.node , triplet.node.left , triplet.level+1));
            if(triplet.node.right != null) queue.offer(new Triplet(triplet.node , triplet.node.right , triplet.level+1));
        }

        return forX.parent != forY.parent && forX.level == forY.level;
    }

    
}