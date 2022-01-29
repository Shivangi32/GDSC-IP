class Solution {
    public int minCut(String s) {
        int n=s.length();
		boolean dp[][]=new boolean[n][n];
		for(int g=0;g<n;g++)
		{
		    for(int i=0,j=g;j<n;i++,j++)
		    {
		        if(g==0)
		          dp[i][j]=true;
		        else if(g==1)
		        {
		            if(s.charAt(i)!=s.charAt(j))
		              continue;
		            dp[i][j]=true;
		        }
		        else
		        {
		            if(s.charAt(i)!=s.charAt(j))
		              continue;
		            dp[i][j]=dp[i+1][j-1];
		        }
		    }
		}
		
		int ans[]=new int[n];
		
		for(int j=1;j<n;j++)
		{
		    if(dp[0][j])
		    {
		        ans[j]=0;
		        continue;
		    }
		    int min=Integer.MAX_VALUE;
		    for(int i=j;i>=1;i--)
		    {
		        if(dp[i][j])
		        {
		            if(ans[i-1]<min)
		              min=ans[i-1];
		        }
		    }
		    ans[j]=min+1;
		}
		

		return ans[n-1];
        
    }
}