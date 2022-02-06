class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int hours=0,ans=Integer.MAX_VALUE;
        int n=piles.length,lo=0,hi=0;;
        for(int i=0;i<n;i++)
        {
            if(piles[i]>hi)
                hi=piles[i];
        }
        if(h==n)
          return hi;
        while(lo<=hi)
        {
            hours=0;
            int mid=(lo+hi)/2;
            for(int i=0;i<n;i++)
            {
                hours+=(int)(Math.ceil(piles[i]*1.0/mid));
            }
            if(hours<=h)
            {
                if(mid<ans)
                    ans=mid;
                hi=mid-1;
            }
            else
                lo=mid+1;
        }
        return ans;
        
    }
}