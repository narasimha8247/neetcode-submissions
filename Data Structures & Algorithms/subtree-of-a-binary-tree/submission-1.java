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
                TreeNode startNode = subRoot(cur, subRoot);
                if(isSameAsSubRoot(startNode, subRoot)){
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

    public TreeNode subRoot(TreeNode root, TreeNode subRoot){
        if(root==null){
            return null;
        }

        if(root.val == subRoot.val){
            return root;
        }

        TreeNode leftNode = subRoot(root.left, subRoot);
        TreeNode rightNode = subRoot(root.right, subRoot);
        if(leftNode!=null){
            return leftNode;
        }else if(rightNode!=null){
            return rightNode;
        }else{
            return null;
        }
    }


}
