class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        int count=0;
        int sum=0;
        hm.put(0,1);
        for(int val:nums)
        {
            sum+=val;
            int rem=sum%k;
            if(rem<0)
               rem+=k;
            if(hm.containsKey(rem))
            {
                count+=hm.get(rem);
                hm.put(rem,hm.get(rem)+1);
            }
            else
            {
                hm.put(rem,1);
            }
        }
        return count;
    }
}