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
    int dia=0;
    public int help(TreeNode node)
    {
        if(node==null)
        return -1;
      int h1=help(node.left)+1;
      int h2=help(node.right)+1;
      dia=Math.max(h1+h2,dia);
      return Math.max(h1,h2);
        
    }
    public int diameterOfBinaryTree(TreeNode node) {
        help(node);
        return dia;
      
    }
}