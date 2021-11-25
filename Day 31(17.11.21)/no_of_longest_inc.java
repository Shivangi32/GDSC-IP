class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int dp[]=new int[nums.length];
        int cnt[]=new int[nums.length];
        if(nums.length==1)
            return 1;
        dp[0]=1;
        cnt[0]=1;
        int maxl=0;
        for(int i=1;i<nums.length;i++)
        {
            int val=nums[i];
            int currl=0,currc=1;
            for(int prev=i-1;prev>=0;prev--)
            {
                if(nums[prev]<val)
                {
                    if(dp[prev]>currl)
                    {
                        currc=cnt[prev];
                        currl=dp[prev];
                    }
                    else if(dp[prev]==currl)
                    {
                        currc+=cnt[prev];
                    }
                }
            }
            dp[i]=currl+1;
            maxl=Math.max(maxl,dp[i]);
            cnt[i]=currc;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(dp[i]==maxl)
              ans+=cnt[i];
        }
        return ans;
    }
}