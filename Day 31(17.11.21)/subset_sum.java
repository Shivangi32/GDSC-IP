// { Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG
    {
        public static void main(String args[])throws IOException
        {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(read.readLine());
            while(t-- > 0)
            {
                int N = Integer.parseInt(read.readLine());
                String input_line[] = read.readLine().trim().split("\\s+");
                int arr[]= new int[N];
                for(int i = 0; i < N; i++)
                    arr[i] = Integer.parseInt(input_line[i]);
                int sum = Integer.parseInt(read.readLine());
    
                Solution ob = new Solution();
                if(ob.isSubsetSum(N, arr, sum))
                System.out.println(1);
                else
                System.out.println(0);
    
                
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    class Solution{
    
    
        static Boolean isSubsetSum(int n, int arr[], int sum){
            // code here
            
            boolean dp[][]=new boolean[n][sum+1];
            dp[0][0]=true;
            if(arr[0]<=sum)
              dp[0][arr[0]]=true;
            for(int i=1;i<n;i++)
            {
                int val=arr[i];
                for(int t=0;t<=sum;t++)
                {
                    if(dp[i-1][t]==true)
                    {
                        dp[i][t]=true;
                        continue;
                    }
                    if(t>=val && dp[i-1][t-val]==true)
                      dp[i][t]=true;
                }
            }
            return dp[n-1][sum];
        }
    }