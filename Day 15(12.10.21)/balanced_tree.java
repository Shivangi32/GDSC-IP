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
    
    boolean ans;
    public int helper(TreeNode root){
        
        if(root==null)
            return 0;
        int left=1+helper(root.left);
        int right=1+helper(root.right);
        if(Math.abs(left-right)>1)
           ans=false;
        return Math.max(left,right);
    }
        
    public boolean isBalanced(TreeNode root) {
        ans=true;
        helper(root);
        return ans;
        
        
    }
}