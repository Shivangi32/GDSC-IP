import java.io.*;
import java.util.*;

public class Main {


  public static class SegmentTree {

    int n;
    int tree[];
    int lazy[];
   
    SegmentTree(int arr[]) {

      tree=new int[arr.length*4];
      lazy=new int[arr.length*4];
      n=arr.length;
      buildTree(arr,tree,0,arr.length-1,1);
    }

    void buildTree(int arr[],int tree[],int st,int end,int treeNode)
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
        int l_val=lazy[treeNode];
        tree[treeNode]+=l_val*(end-st+1);
        
        if(st!=end)            //not leaf node
        {
          lazy[2*treeNode]+=l_val;
          lazy[2*treeNode+1]+=l_val;
        }
        lazy[treeNode]=0;
      }

      //completely outside range
      if(st>r || end<l)
        return;

      //complete overlap
      if(st>=l && end<=r)
      {
        tree[treeNode]+=val*(end-st+1);
        if(st!=end)
        {
          lazy[2*treeNode]+=val;
          lazy[2*treeNode+1]+=val;
        }
        return;
      }
      //partial overlap
      int mid=(st+end)/2;
      update_help(tree,st,mid,l,r,2*treeNode,val);
      update_help(tree,mid+1,end,l,r,2*treeNode+1,val);
      tree[treeNode]=tree[2*treeNode]+tree[2*treeNode+1];
    }
    void update(int l, int r, int val) {

       update_help(tree,0,n-1,l,r,1,val);
    }

    int query_help(int tree[],int st,int end,int l,int r,int treeNode) 
    {
      if(lazy[treeNode]!=0)
      {
        int l_val=lazy[treeNode];
        tree[treeNode]+=l_val*(end-st+1);
        
        if(st!=end)            //not leaf node
        {
          lazy[2*treeNode]+=l_val;
          lazy[2*treeNode+1]+=l_val;
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)
        return 0;
      if(st>=l && end<=r)
      {
        return tree[treeNode];
      }
      int mid=(st+end)/2;
      int ans1=query_help(tree,st,mid,l,r,2*treeNode);
      int ans2=query_help(tree,mid+1,end,l,r,2*treeNode+1);
      return ans1+ans2;
    }
    int query(int l, int r) {

      return query_help(tree,0,n-1,l,r,1);
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
      int l = Integer.parseInt(inp[1]);
      int r = Integer.parseInt(inp[2]);

      if (t == 0) {
        long ans = obj.query(l, r);
        out.append(ans + "\n");
      } else {
        int val = Integer.parseInt(inp[3]);
        obj.update(l, r, val);
      }
    }

    System.out.println(out);
  }

}