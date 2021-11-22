// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        int inc[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        inc[i]+=arr[i];int val=0;
	        
	        for(int j=i-1;j>=0;j--)
	        {
	            if(arr[j]<arr[i])
	            {
	                val=Math.max(inc[j],val);
	            }
	        }
	        inc[i]+=val;
	    }
        
	    int dec[]=new int[n];
	    for(int i=n-1;i>=0;i--)
	    {
	        dec[i]+=arr[i];
	        int val=0;
	        
	        for(int j=i+1;j<n;j++)
	        {
	            if(arr[j]<arr[i])
	            {
	                val=Math.max(dec[j],val);
	            }
	        }
	        dec[i]+=val;
	    }
	    
	    int ans=0;
	    for(int i=0;i<n;i++)
	    {
	        int val=inc[i]+dec[i]-arr[i];
	        ans=Math.max(val,ans);
	    }
	    return ans;
    }
}