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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        // D.F.S
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> dep = new ArrayDeque<>();
        stack.push(root);
        dep.push(1);
        int res = 0;

        while(!stack.isEmpty()){
            
            TreeNode node = stack.pop();
            int curDep = dep.pop();
            res = Math.max(res, curDep);

            if(node.right!=null){
                stack.push(node.right);
                dep.push(1+curDep);
            }
            if(node.left!=null){
                stack.push(node.left);
                dep.push(1+curDep);
            }
        }
        return res;
    }
}
