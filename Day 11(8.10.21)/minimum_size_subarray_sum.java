class Solution {
    public int minSubArrayLen(int tar, int[] nums) {
        
        int n=nums.length;
        int sum=0,i=0,j=0;
        int ans=Integer.MAX_VALUE;
        while(i<n && j<n)
        {
            while(j<n && sum<tar)
            {
                sum+=nums[j];
                j++;
            }
            while(i<j && sum>=tar)
            {
                ans=Math.min(ans,j-i);
                sum-=nums[i];
                i++;
            }
        }
        if(ans==Integer.MAX_VALUE)
            return 0;
        return ans;
        
    }
}