/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;

public class Main {
    
    static int res_fmax;
    static int res_smax;
    
    public static class Pair{
        int fmax;
        int smax;
        
        public Pair(int x,int y){
            fmax=x;
            smax=y;
        }
    }
    public static class SegmentTree {

    Pair tree[];
    int n;
    SegmentTree(int arr[]) {

      n=arr.length;
      tree=new Pair[3*n];
      for(int i=0;i<3*n;i++)
      {
        tree[i]=new Pair(0,0);
      }
      buildTree(arr,tree,0,n-1,1);

    }
    
    void buildTree (int arr[],Pair tree[],int st,int end,int treeNode)
    {
      if(st==end)
      {
        tree[treeNode].fmax=arr[st];
        tree[treeNode].smax=Integer.MIN_VALUE;
        return;
      }
      int mid=(st+end)/2;
      buildTree(arr,tree,st,mid,2*treeNode);
      buildTree(arr,tree,mid+1,end,2*treeNode+1);
      Pair left=tree[2*treeNode];
      Pair right=tree[2*treeNode+1];
      tree[treeNode].fmax=Math.max(left.fmax,right.fmax);
      tree[treeNode].smax=Math.min(Math.max(left.fmax,right.smax),Math.max(right.fmax,left.smax));
    }
    int query(int l,int r)
    {
        res_fmax=Integer.MIN_VALUE;
	    res_smax=Integer.MAX_VALUE;
        query_help(tree,0,n-1,l,r,1);
        return res_fmax+res_smax;
    }
    
    void query_help(Pair tree[],int st,int end,int l,int r,int treeNode)
    {
        if(st>r || end<l)
        {
            return;
        }
        
        if(st>=l && end<=r)
        {
            Pair p=tree[treeNode];
            int max,smax;
            max=Math.max(res_fmax,p.fmax);
            smax=Math.min(Math.max(res_fmax,p.smax),Math.max(p.fmax,res_smax));
            res_fmax=max;
            res_smax=smax;
            System.out.println(st+" "+end+" "+p.fmax+" "+p.smax+" "+res_fmax+" "+res_smax);
            return;
        }
        int mid=(st+end)/2;
        query_help(tree,st,mid,l,r,2*treeNode);
        query_help(tree,mid+1,end,l,r,2*treeNode+1);
        
      }
    }
    public static void main(String[] args) throws Exception {
	    
	   
        int arr[] = { 1,3,2,7,9,11 };
        SegmentTree obj = new SegmentTree(arr);
        int ans=obj.query(2,5);
	    
		System.out.println(ans);
	}
}