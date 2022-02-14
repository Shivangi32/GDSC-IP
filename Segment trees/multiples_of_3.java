import java.io.*;
import java.util.*;

public class Main {

  public static class Segment_tree{
    int tree[][];
    int n;
    int lazy[];

    public Segment_tree(int no)
    {
      n=no;
      tree=new int[4*n][3];
      lazy=new int[4*n];
      buildTree(tree,1,0,n-1);
    }

    void buildTree(int tree[][],int treeNode,int st,int end)
    {
      if(st==end)
      {
        tree[treeNode][0]=1;
        return;
      }
      int mid=(st+end)/2;
      buildTree(tree,2*treeNode,st,mid);
      buildTree(tree,2*treeNode+1,mid+1,end);
      tree[treeNode][0]=tree[2*treeNode][0]+tree[2*treeNode+1][0];
    }

    void shift(int tree[][],int cnt,int treeNode)
    {
      if(cnt%3==0)
        return;
      int rem=cnt%3;
      while(rem-->0)
      {
        int temp=tree[treeNode][2];
        for(int i=0;i<=2;i++)
        {
          int curr=tree[treeNode][i];
          tree[treeNode][i]=temp;
          temp=curr;
        }
      }
    } 
    int query(int st,int end,int l,int r,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        shift(tree,lazy[treeNode],treeNode);
        if(st!=end)
        {
          lazy[2*treeNode]+=lazy[treeNode];
          lazy[2*treeNode+1]+=lazy[treeNode];
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)
        return 0;

      if(st>=l && end<=r)    //complete overlap
      {
        return tree[treeNode][0];
      }
      int mid=(st+end)/2;
      int lans=query(st,mid,l,r,2*treeNode);
      int rans=query(mid+1,end,l,r,2*treeNode+1);
      
      return lans+rans;
    }

    void update(int st,int end,int l,int r,int treeNode)
    {
      if(lazy[treeNode]!=0)
      {
        shift(tree,lazy[treeNode],treeNode);
        if(st!=end)
        {
          lazy[2*treeNode]+=lazy[treeNode];
          lazy[2*treeNode+1]+=lazy[treeNode];
        }
        lazy[treeNode]=0;
      }

      if(st>r || end<l)
        return ;

      if(st>=l && end<=r)    //complete overlap
      {
          shift(tree,1,treeNode);
          if(st!=end)
          {
            lazy[2*treeNode]++;
            lazy[2*treeNode+1]++;
          }
          return;
      }
      int mid=(st+end)/2;
      update(st,mid,l,r,2*treeNode);
      update(mid+1,end,l,r,2*treeNode+1);
      for(int i=0;i<=2;i++)
        tree[treeNode][i]=tree[2*treeNode][i]+tree[2*treeNode+1][i];
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int q = Integer.parseInt(read.readLine());
    Segment_tree obj=new Segment_tree(n);

    while(q-->0)
    {
      String values[]=read.readLine().split(" ");
      int t=Integer.parseInt(values[0]);
      int l=Integer.parseInt(values[1]);
      int r=Integer.parseInt(values[2]);
      if(t==1)
        obj.update(0,n-1,l-1,r-1,1);
      else
        System.out.println(obj.query(0,n-1,l-1,r-1,1));
    }


  }
}
