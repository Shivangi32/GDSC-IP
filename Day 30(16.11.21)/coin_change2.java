class Solution {
    public int change(int amount, int[] coins) {
        
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int coin:coins)
        {
            for(int t=coin;t<=amount && coin<=amount;t++)
            {
                dp[t]+=dp[t-coin];
            }
        }
        return dp[amount];
    }
}