class Solution {
    
    public int help(int grid[][],int i,int j,int val,int color)
      {
          if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
            return 0;
          if(grid[i][j]==-1*val)
            return 1;
          if(grid[i][j]!=val)
            return 0;
          grid[i][j]*=-1;
          int faith=0;
          faith+=help(grid,i,j+1,val,color); //right
          faith+=help(grid,i,j-1,val,color); //left
          faith+=help(grid,i-1,j,val,color); //up
          faith+=help(grid,i+1,j,val,color); //down
          
          if(faith==4)
            grid[i][j]*=-1;
          return 1;
          
      }
      public int[][] colorBorder(int[][] grid, int row, int col, int color) {
          
          help(grid,row,col,grid[row][col],color);
          for(int i=0;i<grid.length;i++)
          {
              for(int j=0;j<grid[0].length;j++)
              {
                  if(grid[i][j]<0)
                     grid[i][j]=color;
              }
          }
          return grid;
      }
}