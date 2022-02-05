class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer>hm=new HashSet<>();
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            int val=nums1[i];
            if(!hm.contains(val))
            {
                hm.add(val);
            }
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            int val=nums2[i];
            if(hm.contains(val))
            {
                ans.add(val);
                hm.remove(val);
            }
        }
        int res[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i]=ans.get(i);
        return res;
    }
}