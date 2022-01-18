public class Solution {

    public class Edge {
        int src;
        int nbr;

        public Edge(int s,int n)
        {
            src=s;
            nbr=n;
        }
    }

    public boolean detectCycle(ArrayList<Edge>graph[],int src,boolean visited[])
    {
        if(visited[src]==true)
          return true;
        visited[src]=true;
        for(Edge ed:graph[src])
        {
            boolean faith=detectCycle(graph,ed.nbr,visited);
            if(faith==true)
              return true;
        }
        visited[src]=false;
        return false;
    }
    public int solve(int A, int[][] B) {

        ArrayList<Edge>graph[]=new ArrayList[A+1];
        for(int i=0;i<=A;i++)
          graph[i]=new ArrayList<>();
        for(int i=0;i<B.length;i++)
        {
            int src=B[i][0];
            int nbr=B[i][1];
            graph[src].add(new Edge(src,nbr));
        }
        boolean visited[]=new boolean[A+1];
        for(int i=1;i<=A;i++)
        {
            boolean faith=detectCycle(graph,i,visited);
            if(faith==true)
              return 1;
        }       
        return 0;
    }
}
