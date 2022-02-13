import java.io.*;
import java.util.*;

public class Main {

  public static class Pair{
    long ss;
    long s;

    public Pair(int x,int y)
    {
      ss=x;
      s=y;
    }
  }
  public static class SegmentTree {

    Pair tree[];
    long lazy[];
    int n;
    SegmentTree(int arr[]) {

      n=arr.length;
      tree=new Pair[4*n];
      for(int i=0;i<4*n;i++)
        tree[i]=new Pair(0,0);
      lazy=new long[4*n];
      buildTree(arr,tree,0,n-1,1);
    }

    void buildTree (int arr[],Pair tree[],int st,int end,int treeNode)
    {
      if(st==end)
      {
        tree[treeNode].ss=arr[st]*arr[st];
        tree[treeNode].s=arr[st];
        return;
      }
      int mid=(st+end)/2;
      buildTree(arr,tree,st,mid,2*treeNode);
      buildTree(arr,tree,mid+1,end,2*treeNode+1);
      tree[treeNode].ss=tree[2*treeNode].ss+tree[2*treeNode+1].ss;
      tree[treeNode].s=tree[2*treeNode].s+tree[2*treeNode+1].s;
    }
    void update(int l,int r, int val) {
      if(val!=0)
        update_help(tree,0,n-1,l,r,1,val);
    }
    void update_help(Pair tree[],int st,int end,int l, int r,int treeNode, int val) {

      if(lazy[treeNode]!=0)
      {
        Pair p=tree[treeNode];
        long l_val=lazy[treeNode];
        p.ss+=2*p.s*l_val+l_val*l_val*(end-st+1);
        p.s+=l_val*(end-st+1);
        
        if(st!=end)            //not leaf node
        {
          lazy[2*treeNode]+=l_val;
          lazy[2*treeNode+1]+=l_val;
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)
        return;
      if(st>=l && end<=r)
      {
        Pair p=tree[treeNode];
        p.ss+=2*p.s*val+val*val*(end-st+1);
        p.s+=val*(end-st+1);
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
       tree[treeNode].ss=tree[2*treeNode].ss+tree[2*treeNode+1].ss;
      tree[treeNode].s=tree[2*treeNode].s+tree[2*treeNode+1].s;

    }
    
    long query_help(Pair tree[],int st,int end,int l,int r,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        Pair p=tree[treeNode];
        long l_val=lazy[treeNode];
        p.ss+=2*p.s*l_val+l_val*l_val*(end-st+1);
        p.s+=l_val*(end-st+1);
        
        if(st!=end)
        {
          lazy[2*treeNode]=l_val;
          lazy[2*treeNode+1]=l_val;
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)   //completely out of range
        return 0;

      if(st>=l && end<=r)
      {
        return tree[treeNode].ss;
      }
      int mid=(st+end)/2;
      long lans=query_help(tree,st,mid,l,r,2*treeNode);
      long rans=query_help(tree,mid+1,end,l,r,2*treeNode+1);
      return lans+rans;
    }

    long query(int l, int r) {

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
      String[] inp = read.readLine().split(" ");

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