import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int v[]=new int[n];
        int w[]=new int[n];
        for(int i=0;i<n;i++)
          v[i]=scn.nextInt();
        for(int i=0;i<n;i++)
          w[i]=scn.nextInt();
        int cap=scn.nextInt();
        int dp[][]=new int[n+1][cap+1];
        for(int i=1;i<=n;i++)
        {
            int value=v[i-1];
            int weight=w[i-1];
            for(int t=0;t<=cap;t++)
            {
                int faith=dp[i-1][t];
                
                if(t>=weight)
                {
                    int incsum=dp[i-1][t-weight]+value;
                    faith=Math.max(faith,incsum);
                }
                dp[i][t]=faith;
            }
        }
        System.out.print(dp[n][cap]);

    }
}