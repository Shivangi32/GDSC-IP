class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int lo=0,hi=n-1;
        int first=-1,last=-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
            {
                first=mid;
                hi=mid-1;
            }
            else if(nums[mid]>target)
            {
                hi=mid-1;
            }
            else
                lo=mid+1;
        }
        lo=0;hi=n-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(nums[mid]==target)
            {
                last=mid;
                lo=mid+1;
            }
            else if(nums[mid]>target)
            {
                hi=mid-1;
            }
            else
                lo=mid+1;
        }
        int ans[]=new int[2];
        ans[0]=first;
        ans[1]=last;
        return ans;
    }
}