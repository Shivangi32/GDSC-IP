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
    public TreeNode help(int[]postorder, int[] inorder, int psi, int pei, int isi, int iei)
    {
        if(psi>pei)
            return null;
        TreeNode node=new TreeNode(postorder[pei]);
        int idx=isi;
        while(inorder[idx]!=postorder[pei])
            idx++;
        int corse=iei-idx;
        node.left=help(postorder, inorder, psi,pei-corse-1,isi,idx-1);
        node.right=help(postorder, inorder, pei-corse,pei-1,idx+1,iei);
        
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n=postorder.length;
        return help(postorder, inorder, 0,n-1,0,n-1);
        
        
    }
}