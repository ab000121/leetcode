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
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = inorder.length-1;
        return BT(inorder , postorder , 0 , inorder.length-1);
    }

    public TreeNode BT(int[] inorder, int[] postorder , int left , int right){
        if(left > right) return null;

        TreeNode root = new TreeNode(postorder[postIdx--]);

        int inIdx = search(inorder , left , right , root.val);

        root.right = BT(inorder , postorder , inIdx+1 , right);
        root.left =  BT(inorder , postorder , left , inIdx-1);

        return root;
    }

    public int search(int[] inorder , int left , int right , int postorderItem){
        for(int i = right ; i >= left; i--){
            if(postorderItem == inorder[i]) return i;
        }
        return -1;
    }
}