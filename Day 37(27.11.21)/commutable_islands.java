public class Solution {

    public class Edge implements Comparable<Edge>{
        int nbr;
        int wt;

        public Edge(int n,int w)
        {
            nbr=n;
            wt=w;
        }
        public int compareTo(Edge e)
        {
            return this.wt-e.wt;
        }
    }

    public int MST(Edge src,ArrayList<Edge>graph[])
    {
        int ans=0;
        boolean visited[]=new boolean[graph.length+1];
        PriorityQueue<Edge>pq=new PriorityQueue<>();
        pq.add(src);
        while(pq.size()>0)
        {
            Edge curr=pq.remove();
            if(visited[curr.nbr]==true)
              continue;
            visited[curr.nbr]=true;
            ans+=curr.wt;
            for(Edge e:graph[curr.nbr])
            {
                if(visited[e.nbr]==true)
                  continue;
                pq.add(new Edge(e.nbr,e.wt));
            }
        }
        return ans;
    }
    public int solve(int A, int[][] B) {

        ArrayList<Edge>graph[]=new ArrayList[A+1];
        for(int i=0;i<=A;i++)
          graph[i]=new ArrayList<>();
        for(int edge[]:B)
        {
            int src=edge[0];
            int nbr=edge[1];
            int wt=edge[2];
            graph[src].add(new Edge(nbr,wt));
            graph[nbr].add(new Edge(src,wt));
        }
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=A;i++)
        {
            Edge src=new Edge(i,0);
            ans=Math.min(ans,MST(src,graph));
        }       
        return ans;

    }
}
