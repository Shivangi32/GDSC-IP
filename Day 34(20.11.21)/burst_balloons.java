class Solution {
    public int maxCoins(int[] arr) {
        
        int n=arr.length;
    int dp[][]=new int[n][n];
    
    for(int g=0;g<n;g++)
    {
        for(int i=0,j=g;j<n;i++,j++)
        {
            for(int k=i;k<=j;k++)
            {
                int left=k==i?0:dp[i][k-1];
                int right=k==j?0:dp[k+1][j];
                int mc=arr[k];
                if(i>0)
                  mc*=arr[i-1];
                if(j!=n-1)
                  mc*=arr[j+1];
                int tc=left+right+mc;
                if(tc>dp[i][j])
                  dp[i][j]=tc;
            }
        }
    }
    return dp[0][n-1];
        
    }
}