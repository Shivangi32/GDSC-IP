public /**
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
   
   public List<Integer>res;
   public int maxlvl=-1;
   
   public void help(TreeNode root,int lvl)
   {
       if(root==null)
           return;
       if(maxlvl<lvl)
       {
           res.add(root.val);
           maxlvl=lvl;
       }
       help(root.right,lvl+1);
       help(root.left,lvl+1);
   }
   
   public List<Integer> rightSideView(TreeNode root) {
       
       res=new ArrayList<>();
       help(root,0);
       return res;
   }
}class right_side_view {
    
}
