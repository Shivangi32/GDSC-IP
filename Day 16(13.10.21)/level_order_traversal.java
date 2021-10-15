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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> main=new ArrayDeque<>();
        Queue<TreeNode> help=new ArrayDeque<>();
        List<List<Integer>>res=new ArrayList<>();
        if(root==null)
            return res;
        main.add(root);
        while(main.size()!=0)
        {
            List<Integer>ans=new ArrayList<>();
            while(main.size()>0)
            {
                TreeNode temp=main.remove();
                ans.add(temp.val);
                if(temp.left!=null)
                    help.add(temp.left);
                if(temp.right!=null)
                    help.add(temp.right);
            }
            res.add(ans);
            main=help;
            help=new ArrayDeque<>();
        }
        return res;
        
    }
}