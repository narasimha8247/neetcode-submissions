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
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // create a hasMap with inroder for value and index
        Map<Integer, Integer> iMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            iMap.put(inorder[i], i);
        }
        return TN(preorder, iMap, 0, inorder.length-1);
    }

    private TreeNode TN(int[] preorder, Map<Integer, Integer> iMap, 
                    int leftIdx, int rightIdx){
        if(leftIdx>rightIdx){
            return null;
        }
        int rootVal = preorder[preIdx++];
        TreeNode treeNode = new TreeNode(rootVal);
        int midIdx = iMap.get(rootVal);
        treeNode.left = TN(preorder, iMap, leftIdx, midIdx-1);
        treeNode.right = TN(preorder, iMap, midIdx+1, rightIdx);
        return treeNode;
    }
}
