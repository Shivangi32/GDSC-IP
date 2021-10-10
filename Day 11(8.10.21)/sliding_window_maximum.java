class Solution {
    
    public int[] nextgreater(int nums[])
    {
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            int val=nums[i];
            int flag=n;
            while(st.size()>0 && nums[st.peek()]<=val)
            {
                st.pop();
            }
            if(st.size()>0)
            {
                flag=st.peek();
            }
            res[i]=flag;
            st.push(i);
        }
        return res;
        
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int ng[]=nextgreater(nums);
        for(int i=0;i<=n-k;i++)
        {
            int wo=i;
            int wc=i+k-1;
            int j=i;
            while(ng[j]<=wc)
            {
                j=ng[j];
            }
            ans[i]=nums[j];
        }
        return ans;      
    
    }
}