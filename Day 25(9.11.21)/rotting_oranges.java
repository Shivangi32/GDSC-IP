class Solution {
        
    public class Pair {
      int row;
      int col;

      Pair(int row, int col) {
        this.row = row;
        this.col = col;
      }
    }
    public int orangesRotting(int[][] grid) {
        
            Queue<Pair>main=new ArrayDeque<>();
      Queue<Pair>helper=new ArrayDeque<>();
      int m=grid.length;
      int n=grid[0].length;
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(grid[i][j]==2)
              {
                  main.add(new Pair(i,j));
              }
          }
      }
      int time=0;
      while(main.size()>0)
      {
         while(main.size()>0)
         {
             Pair p=main.remove();
             int r=p.row;
             int c=p.col;
             System.out.println(r+" "+c+" "+time);
             if(r-1>=0 && grid[r-1][c]==1)
             {
                 helper.add(new Pair(r-1,c));
                 grid[r-1][c]=2;
             }
             if(r+1<m && grid[r+1][c]==1)
             {
                 helper.add(new Pair(r+1,c));
                 grid[r+1][c]=2;
             }
             if(c-1>=0 && grid[r][c-1]==1)
             {
                 helper.add(new Pair(r,c-1));
                 grid[r][c-1]=2;
             }
             if(c+1<n && grid[r][c+1]==1)
             {
                 helper.add(new Pair(r,c+1));
                 grid[r][c+1]=2;
             }
         }
         main=helper;
         helper=new ArrayDeque<>();
         time++;
      }
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(grid[i][j]==1)
                return -1;
          }
      }
      return time==0?time:time-1;
    }
}