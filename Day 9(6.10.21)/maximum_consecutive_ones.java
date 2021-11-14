class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int flip=0;
        int e=0,s=0,n=nums.length,ans=0;
        while(e<n)
        {
            while(e<n && flip<=k)
            {
                int val=nums[e];
                if(val==0)
                {
                    if(flip==k)
                        break;
                    flip++;
                }
                e++;
            }
            ans=Math.max(ans,e-s);
            while(s<n)
            {
                if(nums[s]==0)
                {
                    s++;
                    flip--;
                    break;
                }
                s++;
            }
        }
        return ans;
        
    }
}