class Solution {
    public int longestSubarray(int[] nums, int limit) {
        
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer> max=new PriorityQueue<>(Collections.reverseOrder());
        min.add(nums[0]);
        max.add(nums[0]);
        int s=0,e=0,ans=1;
        while(e<nums.length)
        {
            int curr=max.peek()-min.peek();
            if(curr<=limit)
            {
                ans=Math.max(ans,e-s+1);
                e++;
                if(e<nums.length)
                {
                  min.add(nums[e]);
                  max.add(nums[e]);
                }
            }
            else
            {
                max.remove(nums[s]);
                min.remove(nums[s]);
                s++;
            }
        }
        return ans;
        
    }
}
