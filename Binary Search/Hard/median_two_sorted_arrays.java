class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length>nums2.length)
        {
            int temp[]=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        
        int half=(m+n+1)/2;
        int lo=0,hi=m;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            int bl=half-mid;
            int a2=mid==0?Integer.MIN_VALUE:nums1[mid-1];
            int b3=bl==0?Integer.MIN_VALUE:nums2[bl-1];
            int a3=mid==m?Integer.MAX_VALUE:nums1[mid];
            int b4=bl==n?Integer.MAX_VALUE:nums2[bl];
            if(a2<=b4 && b3<=a3)
            {
                double median=0;
                if((m+n)%2==0)
                {
                    int left=Math.max(a2,b3);
                    int right=Math.min(a3,b4);
                    median=(left+right)/2.0;
                }
                else
                {
                    median=Math.max(a2,b3);
                }
                return median;
            }
            if(a2>b4)
                hi=mid-1;
            else
                lo=mid+1;
        }
        return -1;
    }
}