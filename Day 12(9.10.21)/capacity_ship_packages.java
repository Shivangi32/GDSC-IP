import java.util.*;
import java.io.*;

public class Main {

  public static int shipWithinDays(int[]arr, int m) {
    //write your code here
    int n=arr.length;
    int lo=0,hi=0,ans=0;
    for(int val:arr)
    {
        hi+=val;
        lo=Math.max(lo,val);
    }
    if(m==n)
      return lo;
    while(lo<=hi)
    {
        int mid=(lo+hi)/2;
        int sum=0,day=1;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum>mid)
            {
                sum=arr[i];
                day++;
            }
        }
        if(day<=m)
        {
            ans=mid;
            hi=mid-1;
        }
        else
          lo=mid+1;
    }
    return ans;
    
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int days = scn.nextInt();

    int ans = shipWithinDays(arr, days);
    System.out.println(ans);
  }
}