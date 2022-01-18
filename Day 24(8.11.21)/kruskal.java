
import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int v = Integer.parseInt(br.readLine());
    int e = Integer.parseInt(br.readLine());

    int[][] edges = new int[e][3];
    for (int i = 0; i < e; i++) {
      String[] st = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(st[0]);
      edges[i][1] = Integer.parseInt(st[1]);
      edges[i][2] = Integer.parseInt(st[2]);
    }

    System.out.println(minCostToSupplyWater(v, edges));
  }

  static int[] par;
  static int[] rank;

  public static class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
      this.u = u;
      this.v = v;
      this.wt = wt;
    }

    @Override
    public int compareTo(Pair o) {
      return this.wt - o.wt;
    }
  }
  
  public static int find(int x)
  {
      if(par[x]==-1)
        return x;
      int temp=find(par[x]);
      par[x]=temp;
      return temp;
  }
  public static boolean union(int x,int y){
      
      int lx=find(x);
      int ly=find(y);
      if(lx==ly)
        return true;
      if(rank[lx]<rank[ly])
        par[lx]=ly;
      else if(rank[ly]<rank[lx])
        par[ly]=lx;
      else
      {
          par[lx]=ly;
          rank[ly]++;
      }
      return false;
      
  }
  public static int minCostToSupplyWater(int v, int[][] edges) {
      
      par=new int[v];
      rank=new int[v];
      PriorityQueue<Pair>pq=new PriorityQueue<>();
      for(int edge[]:edges)
      {
          Pair p=new Pair(edge[0],edge[1],edge[2]);
          pq.add(p);
      }
      Arrays.fill(par,-1);
      Arrays.fill(rank,1);
      int ans=0;
      boolean visited[]=new boolean[v];
      while(pq.size()>0)
      {
          Pair p=pq.remove();
          int src=p.u;
          int nbr=p.v;
          if(union(p.u,p.v))
            continue;
          ans+=p.wt;
      }
      return ans;
  }
}
