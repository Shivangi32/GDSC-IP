class Solution {
    public int findPeakElement(int[] arr) {
        
        int n=arr.length;
        int lo=0,hi=n-1,idx=0;
        if(n==1)
            return 0;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(mid==0 && arr[mid]>arr[mid+1])
                return mid;
            else if(mid==n-1 && arr[mid]>arr[mid-1])
                return mid;
            else if(mid>0 && mid<n-1 &&  arr[mid]>arr[mid+1] &&  arr[mid]>arr[mid-1])
            {
                return mid;
            }
            if(arr[mid+1]>arr[mid])
            {
                lo=mid+1;
            }
            else
                hi=mid-1;
        }
        return -1; 
    }
}