import java.io.*;
import java.util.*;

public class Main {

  public static class Node{
    int pdiv[];

    Node()
    {
      pdiv=new int[3];
    }
  }
  public static class SegmentTree {

    Node tree[];
    int n;
    SegmentTree(int arr[]) {

      n=arr.length;
      tree=new Node[4*n];
      for(int i=0;i<4*n;i++)
        tree[i]=new Node();
    }


    void update_div(int st,int end,int l,int r,int div,int treeNode)
    {
      if(st>r || end<l)
      {
        return;
      }
      if(st>=l && end<=r)
      {
        Node curr=tree[treeNode];
        switch(div)
        {
          case 2:  curr.pdiv[0]++;break;
          case 3:  curr.pdiv[1]++;break;
          case 5:  curr.pdiv[2]++;break;
        }
        return;
      }
      int mid=(st+end)/2;
      update_div(st,mid,l,r,div,2*treeNode);
      update_div(mid+1,end,l,r,div,2*treeNode+1);
    }

    void propagate(int arr[],int st,int end,int treeNode)
    {
      if(st!=end)
      {
        for(int i=0;i<3;i++)
          tree[2*treeNode].pdiv[i]+=tree[treeNode].pdiv[i];
        for(int i=0;i<3;i++)
          tree[2*treeNode+1].pdiv[i]+=tree[treeNode].pdiv[i];
      }
      else   //leaf node
      {
        while(arr[st]%2==0 && tree[treeNode].pdiv[0]>0)
        {
          arr[st]/=2;
          tree[treeNode].pdiv[0]--;
        }
        while(arr[st]%3==0 && tree[treeNode].pdiv[1]>0)
        {
          arr[st]=arr[st]/3;
          tree[treeNode].pdiv[1]--;
        }
        while(arr[st]%5==0 && tree[treeNode].pdiv[2]>0)
        {
          arr[st]/=5;
          tree[treeNode].pdiv[2]--;
        }
      }
      for(int i=0;i<3;i++)
          tree[treeNode].pdiv[i]=0;
    }

    void updatept(int arr[],int st,int end,int pos,int treeNode,int val)
    {
      propagate(arr,st,end,treeNode);
      if(st>pos || end<pos)
        return;
      
      if(st==end)
      {
          arr[pos]=val;
        return;
      }
      int mid=(st+end)/2;
      updatept(arr,st,mid,pos,2*treeNode,val);
      updatept(arr,mid+1,end,pos,2*treeNode+1,val);
    }

    void propagateToAll(int arr[],int st,int end,int treeNode)
    {
      propagate(arr,st,end,treeNode);
      if(st==end)
        return;
      int mid=(st+end)/2;
      propagateToAll(arr,st,mid,2*treeNode);
      propagateToAll(arr,mid+1,end,2*treeNode+1);
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    String values[]=read.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }


    SegmentTree obj = new SegmentTree(arr);

    int q = Integer.parseInt(read.readLine());

    StringBuilder out = new StringBuilder();
    while (q-- > 0) {
      String[]inp = read.readLine().split(" ");

      int t = Integer.parseInt(inp[0]);
      if(t==1)     //query
      {
        int l = Integer.parseInt(inp[1]);
        int r = Integer.parseInt(inp[2]);
        int div=Integer.parseInt(inp[3]);
        obj.update_div(0,n-1,l-1,r-1,div,1);
      }
      else
      {
        int idx = Integer.parseInt(inp[1]);
        int val = Integer.parseInt(inp[2]);
        obj.updatept(arr,0,n-1,idx-1,1,val);
      }
    }
    obj.propagateToAll(arr,0,n-1,1);
    for(int i=0;i<n;i++)
      System.out.println(arr[i]);
  }

}