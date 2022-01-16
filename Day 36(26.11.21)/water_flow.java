public class Solution {

    public class Pair{
    int x;
    int y;

    public Pair(int x,int y)
    {
      this.x=x;
      this.y=y;
    }
  }
    public int solve(int[][] A) {
        
        int m=A.length;
        int count=0;
        int n=A[0].length;
        int blue[][]=new int[m][n];  //pacific
        int red[][]=new int[m][n];  //atlantic
        
        Queue<Pair>qu=new ArrayDeque<>();
        for(int j=0;j<n;j++)
        {
            blue[0][j]=1;
            qu.add(new Pair(0,j));
        }
        for(int i=1;i<m;i++)
        {
            blue[i][0]=1;
            qu.add(new Pair(i,0));
        }
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        while(qu.size()>0)
        {
            Pair p=qu.remove();
            for(int d[]:dir)
            {
               int nr=p.x+d[0];
               int nc=p.y+d[1];
               if(nr<0 ||nc<0 ||nr>=A.length ||nc>=A[0].length ||A[nr][nc]<A[p.x][p.y] || blue[nr][nc]==1)
                  continue;
               blue[nr][nc]=1;
               qu.add(new Pair(nr,nc));
            }
        }
        for(int i=0;i<m-1;i++)
        {
            red[i][n-1]=1;
            qu.add(new Pair(i,n-1));
        }
        for(int j=0;j<n;j++)
        {
            red[m-1][j]=1;
            qu.add(new Pair(m-1,j));
        }
        while(qu.size()>0)
        {
            Pair p=qu.remove();
            for(int d[]:dir)
            {
               int nr=p.x+d[0];
               int nc=p.y+d[1];
               if(nr<0 ||nc<0 ||nr>=A.length ||nc>=A[0].length ||A[nr][nc]<A[p.x][p.y] || red[nr][nc]==1)
                 continue;
               red[nr][nc]=1;
               qu.add(new Pair(nr,nc));
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
              {
                  if(blue[i][j]==1 && red[i][j]==1)
                    count++;
              }
        }
        return count;
        
    }
}
