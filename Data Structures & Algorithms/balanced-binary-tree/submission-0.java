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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        
        lrLen(root);
        return balanced;
    }

    public int lrLen(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = lrLen(root.left);
        int right = lrLen(root.right);
        int total = 1 + Math.max(left,right);
        if(Math.abs(right-left)>1){
            balanced = false;
        }
        return total;
    }
}
