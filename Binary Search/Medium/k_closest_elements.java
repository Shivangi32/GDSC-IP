class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        int n=arr.length;
        int lo=0,hi=n-1,mid=0;
        while(lo<=hi)
        {
            mid=(lo+hi)/2;
            if(arr[mid]==x)
            {
                break;
            }
            if(arr[mid]>x)
              hi=mid-1;
            else
              lo=mid+1;
        }
        int left=mid;
        int right=mid+1;
        if(arr[mid]!=x)
        {
            left=hi;
            right=lo;
        }
        while(k>0)
        {
            if(left>=0 && right<n)
            {
                if(x-arr[left]<=arr[right]-x)
                  left--;
                else
                  right++;
            }
            else if(left>=0)
              left--;
            else if(right<n)
              right++;
            k--;
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=left+1;i<right;i++)
        {
            ans.add(arr[i]);
        }
        return ans;
        
    }
}