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
    List<Integer> li = new ArrayList<>();
    int count = 0;
    int required = 0;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        required = k;
        ks(root);
        return res;
    }

    public void ks(TreeNode root){
        if(root==null){
            return;
        }

        ks(root.left);
        count++;
        if(count==required){
            res = root.val;
            return;
        }
        ks(root.right);
    }
}
