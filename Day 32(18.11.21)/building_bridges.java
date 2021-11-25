import java.io.*;
import java.util.*;

public class Main {

  static class pair implements Comparable<pair> {
    int north;
    int south;

    public pair(int n, int s) {

      north = n;
      south = s;
    }

    public int compareTo(pair p)
    {
      if (this.north < p.north)
        return -1;
      if (this.north > p.north)
        return 1;
      if(this.south<p.south)  //both have same north value
        return -1;
      return 1;
    }
  }
  public static void main(String[] args) throws Exception {
    // write your code here

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    pair[] arr = new pair[n];
    for (int i = 0; i < n; i++)
    {
      String values[] = br.readLine().split(" ");
      int north = Integer.parseInt(values[0]);
      int south = Integer.parseInt(values[1]);
      arr[i] = new pair(north, south);
    }
    Arrays.sort(arr);
    int dp[] = new int[n];
    int res=0;
    for (int i = 0; i < n; i++)
    {
      int ans = 0, cs = arr[i].south;
      for (int prev = i - 1; prev >= 0; prev--)
      {
        int ps = arr[prev].south;
        if (ps <= cs)
        {
          ans = Math.max(ans, dp[prev]);
        }
      }
      dp[i] = ans + 1;
      res=Math.max(res,dp[i]);
    }
    System.out.print(res);

  }

}