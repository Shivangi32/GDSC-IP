class Solution {
    public int shortestSubarray(int[] nums, int k) {
        
        int n=nums.length;
        int psum[]=new int[n];
        Deque<Integer>d=new ArrayDeque<Integer>();
        int ans=Integer.MAX_VALUE;
        for(int val:nums)
        {
            if(val==k)
                return 1;
        }
        for(int i=0;i<n;i++)
        {
            if(i==0)
                psum[i]=nums[i];
            else
               psum[i]=psum[i-1]+nums[i];
            if(psum[i]>=k)
                ans=Math.min(ans,i+1);
            while(d.size()>0 && psum[d.getFirst()]<=psum[i]-k)
            {
                ans=Math.min(ans,i- d.getFirst());
                d.removeFirst();
            }
            while(d.size()>0 && psum[i]<=psum[d.getLast()])
                d.removeLast();
            d.addLast(i);
        }
        if(ans!=Integer.MAX_VALUE)
            return ans;
        return -1;
        
    }
}