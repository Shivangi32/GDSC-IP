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
    ArrayList<Integer>values;
    public void getval(TreeNode root)
    {
        if(root==null)
            return;
        getval(root.left);
        values.add(root.val);
        getval(root.right);
        
    }
    public int getMinimumDifference(TreeNode root) {
        values=new ArrayList<>();
        getval(root);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<values.size();i++)
        {
            ans=Math.min(ans,Math.abs(values.get(i)-values.get(i-1)));
        }
        return ans;
        
    }
}