class Solution {
    
    public class pair implements Comparable<pair>{
      int val;
      int freq;
    
      pair(int v,int f)
      {
          val=v;
          freq=f;
      }
        
      public int compareTo(pair p)
      {
          if(this.freq<p.freq)
              return -1;
          if(this.freq>p.freq)
              return 1;
          return 0;
      }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer,Integer>hm=new HashMap<>();
        PriorityQueue<pair>pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
            {
               hm.put(nums[i],hm.get(nums[i])+1);
            }
            else
                hm.put(nums[i],1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            pair p=new pair(key,value);
            pq.add(p);
            if(pq.size()>k)
                pq.remove();
        }
        
        int ans[]=new int[pq.size()];
        int it=0;
        while(pq.size()>0)
        {
            pair p=pq.remove();
            ans[it]=p.val;
            it++;
        }
        return ans;
    }
}
