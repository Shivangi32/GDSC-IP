import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   static ArrayList<ArrayList<Integer>> comps;
   
   public static void getComp(ArrayList<Edge>graph[], int src, ArrayList<Integer>path,boolean visited[])
   {
       int i=0;
       path.add(src);
       visited[src]=true;
       for(Edge e:graph[src])
       {
           if(visited[e.nbr]==false)
              getComp(graph,e.nbr,path,visited);
           i++;
       }
         
   }
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      
      comps = new ArrayList<>();
      boolean visited[]=new boolean[vtces];
      for(int i=0;i<vtces;i++)
      {
          if(visited[i]==true)
             continue;
          visited[i]=true;
          ArrayList<Integer>path=new ArrayList<>();
          getComp(graph,i,path,visited);
          comps.add(path);
      }

      System.out.println(comps);
   }
}