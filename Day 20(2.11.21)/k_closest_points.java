class Solution {
    class pair implements Comparable<pair>{
        int x;
        int y;
        double dis;
        
        pair(int a,int b){
            x=a;
            y=b;
            dis=Math.sqrt((a*a)+(b*b));
        }
        public int compareTo(pair p){
            
            if(this.dis<p.dis)
                return -1;
            if(this.dis>p.dis)
                return 1;
            return 0;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<points.length;i++)
        {
            int x=points[i][0];
            int y=points[i][1];
            pair p=new pair(x,y);
            pq.add(p);
            if(pq.size()>k)
                pq.remove();
        }
        
        int ans[][]=new int[pq.size()][2];
        int i=0;
        while(pq.size()>0)
        {
            pair p=pq.remove();
            ans[i][0]=p.x;
            ans[i][1]=p.y;
            i++;
        }
        return ans;
    }
}