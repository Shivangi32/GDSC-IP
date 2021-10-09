class Solution {
    
    public int helper(int nums[],int k)
    {
        if(k==0)
            return 0;
        int s=0,e=0;
        int n=nums.length;
        HashMap<Integer,Integer>hm=new HashMap<>();
        int count=0;
        while(e<n)
        {
            int val=nums[e];
            if(hm.containsKey(val))
                hm.put(val,hm.get(val)+1);
            else
                hm.put(val,1);
            if(hm.size()<=k)
            {
               count+=(e-s+1);
            }
            else
            {
                while(hm.size()>k)
                {
                    int curr=nums[s];
                    if(hm.get(curr)>1)
                        hm.put(curr,hm.get(curr)-1);
                    else
                        hm.remove(curr);
                    s++;
                    if(hm.size()<=k)
                    {
                        count+=(e-s+1);
                    }
                }
            }
            e++;
        }
        return count;
        
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return helper(nums,k)-helper(nums,k-1);
    }
}