// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int isNegativeWeightCycle(int n, int[][] edges) {

        int path[]=new int[n];
	    Arrays.fill(path,Integer.MAX_VALUE);
	    path[0]=0;
	    for(int i=0;i<n-1;i++)
	    {
	        for(int e[]:edges)
	        {
	            int src=e[0];
	            int nbr=e[1];
	            int wt= e[2];
	            if(path[src]==Integer.MAX_VALUE)
	              continue;
	            if(path[src]+wt<path[nbr])
	              path[nbr]=path[src]+wt;
	        }
	    }
	    for(int e[]:edges)
	    {
	            int src=e[0];
	            int nbr=e[1];
	            int wt= e[2];
	            if(path[src]==Integer.MAX_VALUE)
	              continue;
	            if(path[src]+wt<path[nbr])
	            {
	                return 1;
	            }
	    }
	    return 0;
    }
}