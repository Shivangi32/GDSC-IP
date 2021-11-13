// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean help(ArrayList<Integer>graph[],int src, int count,boolean []visited)
    {
        if(count==visited.length-1)
        {
            return true;
        }
        visited[src]=true;
        for(int nbr:graph[src])
        {
            if(visited[nbr]==false)
            {
                boolean flag=help(graph,nbr,count+1,visited);
                if(flag==true)
                  return true;
            }
        }
        visited[src]=false;
        return false;
    }
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> edges) 
    { 
        // code here
        ArrayList<Integer>[]graph=new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
          graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.size();i++)
        {
            int vert=edges.get(i).get(0);
            int nbr=edges.get(i).get(1);
            graph[vert].add(nbr);
            graph[nbr].add(vert);
        }
        for(int i=1;i<=N;i++)
        {
          boolean visited[]=new boolean[N+1];
          boolean flag= help(graph,i,1,visited);
          if(flag==true)
            return true;
        }
        return false;
    }
} 