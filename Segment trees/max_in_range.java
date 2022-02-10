import java.io.*;
import java.util.*;

public class Main {

  public static class SegmentTree {

    int tree[];
    int n;
    SegmentTree(int arr[]) {

      n=arr.length;
      tree=new int[4*n];
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
      tree[treeNode]=Math.max(tree[2*treeNode],tree[2*treeNode+1]);
    }

    int query_help(int tree[],int st,int end,int l,int r,int treeNode)
    {
      if(l>end || r<st)
      {
        return Integer.MIN_VALUE;
      }
      if(st>=l && end<=r)
      {
        return tree[treeNode];
      }
      int mid=(st+end)/2;
      int lans=query_help(tree,st,mid,l,r,2*treeNode);
      int rans=query_help(tree,mid+1,end,l,r,2*treeNode+1);
      return Math.max(lans,rans);
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

      int l = Integer.parseInt(inp[0]);
      int r = Integer.parseInt(inp[1]);

      int ans = obj.query(l, r);
      out.append(ans);
      out.append("\n");
    }

    System.out.println(out);
  }

}