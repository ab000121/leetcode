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

 class Pair{
    long index;
    TreeNode node;
    public Pair(){}

    public Pair(TreeNode node , long index){
        this.node = node;
        this.index = index;
    }
 }
class Solution {
    long index = 0;
    long max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root , 0));

        while(!queue.isEmpty()){
            int size = queue.size();

            long startIdx = queue.peekFirst().index;
            long endIdx = queue.peekLast().index;
            max = Math.max(max , endIdx - startIdx +1);

            for(int i = 0 ; i < size ; i++){
                Pair pair = queue.poll();
                if(pair.node.left !=  null){
                    queue.offer(new Pair(pair.node.left , (2*pair.index)+1));
                }
                if(pair.node.right !=  null){
                    queue.offer(new Pair(pair.node.right , (2*pair.index)+2));
                }
            }
        }
        return (int)max;
    }
}