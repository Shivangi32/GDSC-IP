class Solution {
    public int combinationSum4(int[] nums, int target) {
        
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int t=1;t<=target;t++)
        {
            for(int val:nums)
            {
                if(val<=t)
                {
                    dp[t]+=dp[t-val];
                }
            }
        }
        return dp[target];
    }
}