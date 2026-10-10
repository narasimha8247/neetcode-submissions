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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // traverse until sub root
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                
                if(isSameAsSubRoot(cur, subRoot)){
                    return true;
                }
                
                if(cur.left!=null){
                    queue.offer(cur.left);
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                }
            }
        }
        
        return false;
    }

    public boolean isSameAsSubRoot(TreeNode root, TreeNode subRoot){
        if(subRoot==null || root==null){
            return subRoot==root;
        }
        
        return (root.val==subRoot.val) && isSameAsSubRoot(root.left, subRoot.left)
                && isSameAsSubRoot(root.right, subRoot.right);

    }


}
