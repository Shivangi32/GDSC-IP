import java.io.*;
import java.util.*;

public class Main {

  static long tree[][];
  static int arr[];
  static int k;
  
  public static long[] sum(long l[],long r[])
  {
    long ans[]=new long[k+1];
    for(int i=1;i<=k;i++)
      ans[i]=l[i]+r[i];
    return ans;
  }
  
  public static void update(int st,int end,int val,long ans[],int treeNode)
  {
    if(st==end)
    {
      tree[treeNode]=ans;
      return;
    }
    int mid=(st+end)/2;
    if(st<=val && val<=mid)
      update(st,mid,val,ans,2*treeNode);
    else
      update(mid+1,end,val,ans,2*treeNode+1);
    tree[treeNode]=sum(tree[2*treeNode],tree[2*treeNode+1]);      
  }

  public static long[] query(int st,int end,int l,int r,int treeNode){
   
    if(st>r || end<l)
      return new long[k+1];
    if(st==end)
       return tree[treeNode];
    if(st>=l && end<=r)
    {
      return tree[treeNode];
    }
    int mid=(st+end)/2;
    long la[]=query(st,mid,l,r,2*treeNode);
    long ra[]=query(mid+1,end,l,r,2*treeNode+1);

    return sum(la,ra);

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    k = Integer.parseInt(read.readLine());

    arr = new int[n];

    for (int i = 0; i < n; i++) {
      long ans[];
      if (arr[i] == 1) {
        ans = new long[k + 1];
        ans[1] = 1;
      } else { // 1..ar[i]-1
        long []sum = query(1, n, 1, arr[i] - 1,1);
        ans = new long[k + 1];
        for (int l = 2; l <= k; l++) {
          ans[l] = sum[l - 1];
        }
        ans[1] = 1;
      }

      update( 1, n, arr[i], ans,1);
    }

    long ans = tree[1][k];

    System.out.println(ans);

  }
}
