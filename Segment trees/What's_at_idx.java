import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    int tree[];
    int lazy[];
    int n;
    SegmentTree(int arr[]) {

      n=arr.length;
      tree=new int[4*n];
      lazy=new int[4*n];
      buildTree(arr,tree,0,n-1,1);

    }

    void buildTree (int arr[],int tree[],int st,int end,int treeNode)
    {
      if(st==end)
      {
        tree[treeNode]=arr[st];
        return;
      }
      int mid=(st+end)/2;
      buildTree(arr,tree,st,mid,2*treeNode);
      buildTree(arr,tree,mid+1,end,2*treeNode+1);
      tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
    }
    
    void update_help(int tree[],int st,int end,int l,int r,int treeNode,int val)
    {
      if(lazy[treeNode]!=0)
      {
        int inc=lazy[treeNode]*(end-st+1);
        tree[treeNode]+=inc;
        if(st!=end)
        {
          lazy[2*treeNode]+=lazy[treeNode];
          lazy[2*treeNode+1]+=lazy[treeNode];
        }
        lazy[treeNode]=0;
      }
      if(st>r || end<l)
        return;
      if(st>=l && end<=r)
      {
        int inc=val*(end-st+1);
        tree[treeNode]+=inc;
        if(st!=end)
        {
          lazy[2*treeNode]+=val;
          lazy[2*treeNode+1]+=val;
        }
        return;
      }
      int mid=(st+end)/2;
      update_help(tree,st,mid,l,r,2*treeNode,val);
      update_help(tree,mid+1,end,l,r,2*treeNode+1,val);
      tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
    }

    void update(int l,int r, int val) {
      if(val!=0)
        update_help(tree,0,n-1,l,r,1,val);
    }


    int query_help(int tree[],int st,int end,int idx,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        int inc=lazy[treeNode]*(end-st+1);
        tree[treeNode]+=inc;
        if(st!=end)
        {
          lazy[2*treeNode]+=lazy[treeNode];
          lazy[2*treeNode+1]+=lazy[treeNode];
        }
        lazy[treeNode]=0;
      }

      if(st>idx || end<idx)   //completely out of range
        return -1;

      if(st==end)
      {
        return tree[treeNode];
      }
      int mid=(st+end)/2;
      int ans=query_help(tree,st,mid,idx,2*treeNode);
      if(ans!=-1)
        return ans;
      ans=query_help(tree,mid+1,end,idx,2*treeNode+1);
      return ans;
    }

    int query(int idx) {
      return query_help(tree,0,n-1,idx,1);
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(read.readLine());
    }

    SegmentTree obj = new SegmentTree(arr);

    int q = Integer.parseInt(read.readLine());

    StringBuilder out = new StringBuilder();
    while (q-- > 0) {
      String[]inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);

      if (t == 0) {
        int ind = Integer.parseInt(inp[1]);
        long ans = obj.query(ind);
        out.append(ans + "\n");
      } else {
        int l = Integer.parseInt(inp[1]);
        int r = Integer.parseInt(inp[2]);
        int val = Integer.parseInt(inp[3]);
        obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}