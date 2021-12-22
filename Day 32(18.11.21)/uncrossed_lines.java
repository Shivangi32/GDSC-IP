class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        
        int s1=nums1.length;
        int s2=nums2.length;
        int dp[][]=new int[s1+1][s2+1];
        for(int i=1;i<=s1;i++)
        {
            int v1=nums1[i-1];
            for(int j=1;j<=s2;j++)
            {
                int v2=nums2[j-1];
                if(v1==v2)
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s1][s2];
        
    }
}