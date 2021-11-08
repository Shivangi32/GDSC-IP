/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception{
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0)
        {
            String values[]=br.readLine().split(" ");
            int n = Integer.parseInt(values[0]);
            int k = Integer.parseInt(values[1]);
            if(k==n)
              k--;
            values=br.readLine().split(" ");
            int arr[]=new int[values.length];
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=Integer.parseInt(values[i]);
            }
            PriorityQueue<Integer>pq=new PriorityQueue<>();
            for(int i=0;i<=k;i++)
            {
               pq.add(arr[i]);
            }
            int j=0;
            for(int i=k+1;i<n;i++)
            {
               arr[j]=pq.remove();
               pq.add(arr[i]);
               j++;
            }
            while(pq.size()>0)
            {
               arr[j]=pq.remove();
               j++;
            }
            for(int val:arr)
               System.out.print(val+" ");
            t--;
            System.out.println();
        }
	}
}