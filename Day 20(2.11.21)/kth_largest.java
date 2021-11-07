class KthLargest {
    
    PriorityQueue<Integer>pq=new PriorityQueue<>();
    int kth;

    public KthLargest(int k, int[] nums) {
        
        kth=k;
        for(int val:nums)
        {
            pq.add(val);
            if(pq.size()>k)
                pq.remove();
        }
        
    }
    
    public int add(int val) {
        
        pq.add(val);
        if(pq.size()>kth)
            pq.remove();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */