class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n=nums.length;
        int dp[]=new int[n];
        dp[0]=1;
        int ans=1;
        for(int i=1;i<n;i++)
        {
            int faith=0;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                    faith=Math.max(faith,dp[j]);
            }
            dp[i]=faith+1;
            ans=Math.max(ans,dp[i]);
        }
        return ans;
        
        
    }
}