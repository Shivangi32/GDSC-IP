class Solution {
    
    public class Pair {
      int x;
      int y;

      Pair(int row, int col) {
        x = row;
        y = col;
      }
    }
    public int maxDistance(int[][] grid) {
        
      Queue<Pair>qu=new ArrayDeque<>();
      Queue<Pair>helper=new ArrayDeque<>();
      int m=grid.length;
      int n=grid[0].length;
      for(int i=0;i<m;i++)
      {
          for(int j=0;j<n;j++)
          {
              if(grid[i][j]==1)
              {
                  qu.add(new Pair(i,j));
              }
          }
      }
      int dis=0;
      int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        while(qu.size()>0)
        {
            while(qu.size()>0)
            {
              Pair p=qu.remove();
              int cr=p.x,cc=p.y;
              for(int d[]:dir)
              {
                int nr=cr+d[0];
                int nc=cc+d[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n || grid[nr][nc]==1)
                    continue;
                grid[nr][nc]=1;
                helper.add(new Pair(nr,nc));
              }
            }
            dis++;
            qu=helper;
            helper=new ArrayDeque<>();
        }
        if(dis==1)
            return -1;
        return dis-1;
        
    }
}