class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        
        Stack<Integer>st=new Stack<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            int val=nums2[i];
            while(st.size()>0 && st.peek()<=val)
                st.pop();
            int flag=-1;
            if(st.size()>0)
                flag=st.peek();
            hm.put(val,flag);
            st.push(val);
        }
        int res[]=new int[nums1.length];
        for(int j=0;j<nums1.length;j++)
        {
            res[j]=hm.get(nums1[j]);
        }
        return res;
        
    }
}