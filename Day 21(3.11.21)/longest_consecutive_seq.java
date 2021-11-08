public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {

        HashMap<Integer,Boolean>hm=new HashMap<>();
        for(int val:A)
        {
            hm.put(val,true);
        }
        for(int val:A)
        {
            if(hm.containsKey(val-1))
            {
                hm.put(val,false);
            }
        }
        int l=0;
        for(int val:A)
        {
            if(hm.get(val)==true)
            {
                int no=val;
                int curr=0;
                while(hm.containsKey(no))
                {
                    no++;
                    curr++;
                }
                l=Math.max(curr,l);
            }
        }
        return l;

    }
}