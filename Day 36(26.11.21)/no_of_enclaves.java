class Solution {
    
    public void help(int grid[][],int i,int j){
      
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j]==0)
            return ;
        grid[i][j]=0;
        help(grid,i,j+1); //right
        help(grid,i,j-1); //left
        help(grid,i-1,j); //up
        help(grid,i+1,j); //down
    }
    public int numEnclaves(int[][] arr) {
      
      int m=arr.length;
      int n=arr[0].length,res=0;
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(i==0 || j==0 || i==m-1 || j==n-1)
              {
                  if(arr[i][j]==1)
                  help(arr,i,j);
              }
          }
      }
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(arr[i][j]==1)
                 res++;
          }
      }
      return res;
    }
}