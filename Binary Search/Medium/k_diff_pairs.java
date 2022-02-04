class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);
        int n=nums.length;
        int cnt=0;
        if(k==0)
        {
            for(int i=0;i<n;i++)
            {
                if(i<n-1 && nums[i]==nums[i+1])
                {
                    while(i<n-1 && nums[i]==nums[i+1])
                        i++;
                    cnt++;
                }
            }
            return cnt;
        }
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int val=nums[i];
            int idx=bin_Search(nums,0,i-1,val-k);
            if(idx!=-1)
              cnt++;
        }
        return cnt;
    }
    
    public int bin_Search(int arr[],int lo,int hi,int tar)
    {
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(arr[mid]==tar)
               return mid;
            if(arr[mid]>tar)
                hi=mid-1;
            else
                lo=mid+1;
        }
        return -1;
    }
}