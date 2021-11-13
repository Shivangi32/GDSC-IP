class Solution {
    
    class Pair{
        int vert;
        int level;
        
        Pair(int v,int l)
        {
            vert=v;
            level=l;
        }
    }
    
    public boolean isBipart(ArrayList<Integer>graph[], int src, int visited[])
    {
        ArrayDeque<Pair>queue=new ArrayDeque<>();
        queue.add(new Pair(src,1));
        while(queue.size()>0)
        {
            Pair p=queue.remove();
            if(visited[p.vert]!=0)
            {
                if(visited[p.vert]!=p.level)
                    return false;
                continue;
            }
            visited[p.vert]=p.level;
            for(int nbr:graph[p.vert])
            {
                if(visited[nbr]==0)
                  queue.add(new Pair(nbr,p.level+1));   
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<Integer>graph[]=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            graph[i]=new ArrayList<>();
        for(int i=0;i<dislikes.length;i++)
        {
            int vert=dislikes[i][0];
            int nbr=dislikes[i][1];
            graph[vert].add(nbr);
            graph[nbr].add(vert);
        }
        int visited[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            if(visited[i]!=0)
                continue;
            boolean ans=isBipart(graph, i,visited);
            if(ans==false)
                return false;
        }
        return true;
        
    }
}