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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        dbt(root);
        return max;

    }

    public int dbt(TreeNode root) {
        if(root==null){
            return 0;
        }

        int left = dbt(root.left);
        int right = dbt(root.right);
        int diameter = 1 + Math.max(left,right);
        max = Math.max(max,left+right);
        return diameter;

    }
}
