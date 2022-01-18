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
    
    public int prev;
    public int i;
    boolean flag;
    public void help(TreeNode root)
    {
        if(root==null)
            return;
        help(root.left);
        if(flag==false)
            return;
        if(i>0 && prev>=root.val)
        {
            flag=false;
            return;
        }
        i++;
        prev=root.val;
        help(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        
        flag=true;
        prev=0;
        i=0;
        help(root);
        return flag;
        
            
    }
}