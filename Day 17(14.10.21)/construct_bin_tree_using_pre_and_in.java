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
    
    public TreeNode help(int[]preorder, int[] inorder, int psi, int pei, int isi, int iei)
    {
        if(isi>iei)
            return null;
        TreeNode node=new TreeNode(preorder[psi]);
      
        int idx=isi;
        while(inorder[idx]!=preorder[psi])
            idx++;
        int colse=idx-isi;
        node.left=help(preorder, inorder, psi+1,psi+colse,isi,idx-1);
        node.right=help(preorder, inorder, psi+colse+1,pei,idx+1,iei);
        
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int n=preorder.length;
        return help(preorder, inorder, 0,n-1,0,n-1);
        
    }
}