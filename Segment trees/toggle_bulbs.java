import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    int tree[];
    int lazy[];
    int n;

    public SegmentTree(int no) {

      n=no;
      tree=new int[4*n];
      lazy=new int[4*n];
    }

    void toggle(int st,int end,int l,int r,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        tree[treeNode]=end-st+1-tree[treeNode];
        if(st!=end)
        {
          lazy[2*treeNode]=(lazy[2*treeNode]+1)%2;
          lazy[2*treeNode+1]=(lazy[2*treeNode+1]+1)%2;
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)     //completely outside
        return;

      if(st>=l && end<=r) //complete overlap
      {
        tree[treeNode]=end-st+1-tree[treeNode];
        if(st!=end)
        {
          lazy[2*treeNode]=(lazy[2*treeNode]+1)%2;
          lazy[2*treeNode+1]=(lazy[2*treeNode+1]+1)%2;
        }
        return;
      }

      int mid=(st+end)/2;
      toggle(st,mid,l,r,2*treeNode);
      toggle(mid+1,end,l,r,2*treeNode+1);
      tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
    }

    int query(int st,int end,int l,int r,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        tree[treeNode]=end-st+1-tree[treeNode];
        if(st!=end)
        {
          lazy[2*treeNode]=(lazy[2*treeNode]+1)%2;
          lazy[2*treeNode+1]=(lazy[2*treeNode+1]+1)%2;
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)     //completely outside
        return 0;

      if(st>=l && end<=r) //complete overlap
      {
        return tree[treeNode];
      }

      int mid=(st+end)/2;
      int left=query(st,mid,l,r,2*treeNode);
      int right=query(mid+1,end,l,r,2*treeNode+1);
      return left+right;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inps[] = read.readLine().split(" ");
    int n = Integer.parseInt(inps[0]);
    int q = Integer.parseInt(inps[1]);
    SegmentTree obj=new SegmentTree(n);
    for(int i=0;i<q;i++)
    {
      inps= read.readLine().split(" ");
      if(Integer.parseInt(inps[0])==1)
        obj.toggle(0,n-1,Integer.parseInt(inps[1])-1,Integer.parseInt(inps[2])-1,1);
      else
      {
        int ans=obj.query(0,n-1,Integer.parseInt(inps[1])-1,Integer.parseInt(inps[2])-1,1);
        System.out.println(ans);
      }
    }

  }

}