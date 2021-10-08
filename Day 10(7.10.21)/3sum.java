class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        if(n<3)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++)
        {
            int tar=0-nums[i];
            int s=i+1,e=n-1;
            while(s<e)
            {
                int sum=nums[s]+nums[e];
                if(sum<tar)
                    s++;
                else if(sum>tar)
                    e--;
                else
                {
                    List<Integer>temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    res.add(temp);
                    while(s<n-1 && nums[s]==nums[s+1])
                        s++;
                    s++;
                    while(e>0 && nums[e]==nums[e-1])
                        e--;
                    e--;
                }
                while(i<n-2 && nums[i]==nums[i+1])
                  i++;
            }
        }
        return res;
        
    }
}