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
    public int goodNodes(TreeNode root) {
        return gd(root, root.val);
    }

    public int gd(TreeNode root, int soFarMax){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.val >= soFarMax ){
            res++;
        } 

        soFarMax = Math.max(root.val, soFarMax);
        int left = gd(root.left, soFarMax);
        int right = gd(root.right, soFarMax);
        return res+left+right;
    }
}
