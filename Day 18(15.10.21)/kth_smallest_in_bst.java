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
    
    public ArrayList<Integer>res;
    
    public void help(TreeNode root)
    {
        if(root==null)
            return;
        help(root.left);
        res.add(root.val);
        help(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        
        res=new ArrayList<>();
        help(root);
        k--;
        return res.get(k);
            
        
    }
}