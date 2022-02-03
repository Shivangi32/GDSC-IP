class Solution {
    public int singleNonDuplicate(int[] arr) {
        
        int n=arr.length;
        int lo=0,hi=n-1;
        while(lo<hi)
        {
            int mid=(lo+hi)/2;
            int prev=mid>0?arr[mid-1]:-1;
            int next=mid<n-1?arr[mid+1]:-1;
            if(!(arr[mid]==prev || arr[mid]==next))
            {
                System.out.print(mid);
                return arr[mid];
            }
            else
            {
                int len=(mid-lo)%2;
                if(len==0)
                {
                    System.out.println("even"+mid);
                    if(arr[mid]==prev)
                        hi=mid-2;
                    else if(arr[mid]==next)
                        lo=mid+2;    
                }
                else
                {
                    System.out.println("odd"+mid);
                    if(arr[mid]==prev)
                        lo=mid+1;
                    else if(arr[mid]==next)
                        hi=mid-1;    
                }
            }
        }
        return arr[lo];
        
    }
}