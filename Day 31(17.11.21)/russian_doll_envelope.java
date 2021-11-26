class Solution {
    
    public class pair implements Comparable<pair>{
        int h;
        int w;
        
        public pair(int height, int width) {

          h = n;
          w = s;
       }
        public int compareTo(pair p){
           
         if (this.h < p.h)
           return -1;
         if (this.h > p.h)
           return 1;
         if(this.w<p.w)  //both have same north value
           return -1;
         return 1;
       } 
    }
    public int maxEnvelopes(int[][] envelopes) {
        
    int n=envelopes.length;
    pair[] arr = new pair[n];
    for (int i = 0; i < n; i++)
    {
       arr[i] = new pair(envelopes[i][0], envelopes[i][1]);
    }
    Arrays.sort(arr);
    int dp[] = new int[n];
    int res=0;
    for (int i = 0; i < n; i++)
    {
      int ans = 0, cs = arr[i].w;
      for (int prev = i - 1; prev >= 0; prev--)
      {
        int ps = arr[prev].w;
        if (arr[prev].h<arr[i].h && ps < cs)
        {
          ans = Math.max(ans, dp[prev]);
        }
      }
      dp[i] = ans + 1;
      res=Math.max(res,dp[i]);
    }
        return res;
    }
}