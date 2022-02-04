class Solution{

  public int findRotationCount(int[]arr) {

    int n=arr.length;
    int lo=0,hi=n-1;
    while(lo<=hi)
    {
        if(arr[lo]<=arr[hi])
        {
            return lo;
        }
        int mid=(lo+hi)/2;
        int prev=(mid-1+n)%n;
        int next=(mid+1)%n;
        if(arr[mid]<=arr[prev] && arr[mid]<=arr[next])
        {
            return mid;
        }
        else if(arr[lo]<=arr[mid])
            lo=mid+1;
        else
            hi=mid-1;
    }
    return -1;
  }
}