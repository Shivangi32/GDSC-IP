// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int arr[][])
    {
        // code here
        int dp[][]=new int[n][m];
        int max=0;
        for(int i=0;i<n;i++)
        {
            dp[i][m-1]=arr[i][m-1];
            max=Math.max(max,dp[i][m-1]);
        }
        for(int j=m-2;j>=0;j--)
        {
            max=0;
            for(int i=0;i<n;i++)
            {
                int val=dp[i][j+1];
                if(i-1>=0)
                  val=Math.max(val,dp[i-1][j+1]);
                if(i+1<n)
                  val=Math.max(val,dp[i+1][j+1]);
                dp[i][j]=val+arr[i][j];
                max=Math.max(max,dp[i][j]);
            }
            
        }
        return max;
    }
}