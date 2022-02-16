class Solution {
    
    class Node{
        int max_sum;
        int sum;
        int bps;
        int bss;
        
        public Node(int a,int b,int c,int d){
            max_sum=a;
            sum=b;
            bps=c;
            bss=d;
        }
    }
    
    public class Segment_tree{
        
        Node tree[];
        int n;
        
        public Segment_tree(int arr[]){
            int n=arr.length;
            tree=new Node[4*n];
            for(int i=0;i<4*n;i++)
            {
                tree[i]=new Node(0,0,0,0);
            }
            buildTree(arr,0,n-1,1);
        }
        
        public Node merge(Node l, Node r)
        {
            if(l==null && r==null)
            {
                return null;                
            }
            if(l==null)
                return r;
            if(r==null)
                return l;
            
            Node parentNode=new Node(0,0,0,0);
            int max_sum=Math.max(l.max_sum,r.max_sum);;
            parentNode.max_sum=Math.max(max_sum,l.bss+r.bps);
            parentNode.sum=l.sum+r.sum;
            parentNode.bss=Math.max(l.bss+r.sum,r.bss);
            parentNode.bps=Math.max(l.bps,l.sum+r.bps);
            return parentNode;
        }
        void buildTree(int arr[],int st,int end,int treeNode)
        {
            Node curr=tree[treeNode];
            if(st==end)
            {
                curr.max_sum=arr[st];
                curr.sum=arr[st];
                curr.bps=arr[st];
                curr.bss=arr[st];
                return;
            }
            int mid=(st+end)/2;
            buildTree(arr,st,mid,2*treeNode);
            buildTree(arr,mid+1,end,2*treeNode+1);
            tree[treeNode]= merge(tree[2 * treeNode], tree[2 * treeNode + 1]);
        }
        
        public Node query(int st,int end,int l,int r,int treeNode)
        {
            if(st>r || end<l)
                return null;
            if(st>=l && end<=r)
            {
                return tree[treeNode];
            }
            int mid=(st+end)/2;
            Node left=query(st,mid,l,r,2*treeNode);
            Node right=query(mid+1,end,l,r,2*treeNode+1);
            Node res=merge(left,right);
            return res;
        }
    }
    public int maxSubArray(int[] nums) {
        Segment_tree obj=new Segment_tree(nums);
        int n=nums.length;
        Node res=obj.query(0,n-1,0,n-1,1);
        return res.max_sum;
        
    }
}