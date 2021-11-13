// { Driver Code Starts
    import java.util.*;
    import java.io.*;
    import java.lang.*;
    
    class DriverClass
    {
        public static void main(String args[]) throws IOException {
    
            BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while (t-- > 0) {
                String str[] = read.readLine().trim().split(" ");
                int V = Integer.parseInt(str[0]);
                int E = Integer.parseInt(str[1]);
        
                ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
                for(int i=0;i<V;i++)
                {
                    adj.add(new ArrayList<ArrayList<Integer>>());
                }
                
                int i=0;
                while (i++<E) {
                    String S[] = read.readLine().trim().split(" ");
                    int u = Integer.parseInt(S[0]);
                    int v = Integer.parseInt(S[1]);
                    int w = Integer.parseInt(S[2]);
                    ArrayList<Integer> t1 = new ArrayList<Integer>();
                    ArrayList<Integer> t2 = new ArrayList<Integer>();
                    t1.add(v);
                    t1.add(w);
                    t2.add(u);
                    t2.add(w);
                    adj.get(u).add(t1);
                    adj.get(v).add(t2);
                }
                
                int S = Integer.parseInt(read.readLine());
                
                Solution ob = new Solution();
                
                int[] ptr = ob.dijkstra(V, adj, S);
                
                for(i=0; i<V; i++)
                    System.out.print(ptr[i] + " ");
                System.out.println();
            }
        }
    }// } Driver Code Ends
    
    
    //User function Template for Java
    
    
    class Solution
    {
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        
        static class Pair implements Comparable<Pair>{
            
            int vert;
            int dsf;
            
            Pair(int v,int d){
                vert=v;
                dsf=d;
            }
            public int compareTo(Pair p)
            {
                if(this.dsf<p.dsf)
                  return -1;
                if(this.dsf>p.dsf)
                  return 1;
                return 0;
            }
        }
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            // Write your code here
            PriorityQueue<Pair>pq=new PriorityQueue<>();
            int ans[]=new int[V];
            boolean visited[]=new boolean[V];
            pq.add(new Pair(S,0));
            while(pq.size()>0)
            {
                Pair p=pq.remove();
                if(visited[p.vert]==true)
                  continue;
                visited[p.vert]=true;
                ans[p.vert]=p.dsf;
                for(int j=0;j<adj.get(p.vert).size();j++)
                {
                    int nbr=adj.get(p.vert).get(j).get(0);
                    int wt=adj.get(p.vert).get(j).get(1);
                    pq.add(new Pair(nbr,p.dsf+wt));
                }
            }
            
            return ans;
        }
    }
    
    