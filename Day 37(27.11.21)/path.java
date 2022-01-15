public class Solution {

    public boolean find(int i,int j,int A[][])
    {
        if(i<0 || j<0 || i>=A.length || j>=A.length || A[i][j]==0 || A[i][j]==-1)
          return false;
        
        if(A[i][j]==2)
          return true;
        boolean faith=false;
        A[i][j]=-1;
        faith=find(i+1,j,A);
        if(faith==true)
          return true;
        faith=find(i-1,j,A);
        if(faith==true)
          return true;
        faith=find(i,j-1,A);
        if(faith==true)
          return true;
        faith=find(i,j+1,A);
        if(faith==true)
          return true;
        A[i][j]=3;
        return false;
    }
    public int checkPath(int[][] A) {

        int srcx=0,srcy=0;
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                if(A[i][j]==1)
                {
                    srcx=i;srcy=j;
                    break;
                }
            }
        }
        boolean ans=find(srcx,srcy,A);
        if(ans==true)
          return 1;
        return 0;

    }
}
