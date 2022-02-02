class Solution {
    public int search(int[] arr, int target) {
        
        int n=arr.length;
        int lo=0,hi=n-1,idx=0;
        while(lo<=hi)
        {
            if(arr[lo]<=arr[hi])
            {
                idx=lo;
                break;
            }
            int mid=(lo+hi)/2;
            int prev=(mid-1+n)%n;
            int next=(mid+1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next])
            {
                idx=mid;
                break;
            }
            else if(arr[lo]<=arr[mid])
                lo=mid+1;
            else
                hi=mid-1;
        }
        int ans=binarySearch(arr,target,0,idx-1);
        if(ans==-1)
            ans=binarySearch(arr,target,idx,n-1);
        return ans;
    }
    
    public int binarySearch(int arr[],int tar,int lo,int hi)
    {
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(arr[mid]==tar)
            {
                return mid;
            }
            else if(arr[mid]<tar)
                lo=mid+1;
            else
                hi=mid-1;
        }
        return -1;
    }
}