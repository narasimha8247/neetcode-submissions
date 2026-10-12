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
    public int kthSmallest(TreeNode root, int k) {
        ks(root);
        return li.get(k-1);
    }

    public void ks(TreeNode root){
        if(root==null){
            return;
        }

        ks(root.left);
        li.add(root.val);
        ks(root.right);
    }
}
