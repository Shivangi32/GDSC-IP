class Solution {
    public int arrangeCoins(int n) {
        
        long lo=1,hi=n;
        while(lo<=hi)
        {
            long mid=lo+(hi-lo)/2;      //mid denotes max rows possible
            long max_coin=(mid*(mid+1))/2;       //total coins in mid no of rows
            if(max_coin== n)
                return (int)mid;
            else if(max_coin>n)
                hi=mid-1;
            else
                lo=mid+1;
        }
        return (int)hi;
        
    }
}