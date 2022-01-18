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

  public int checkPath(int[][] A) {

      int srcx=0,srcy=0,desx=0,desy=0;
      for(int i=0;i<A.length;i++)
      {
          for(int j=0;j<A[0].length;j++)
          {
              if(A[i][j]==1)
              {
                  srcx=i;srcy=j;
              }
              if(A[i][j]==2)
              {
                  desx=i;desy=j;
              }
          }
      }
      
      Queue<Pair>qu=new ArrayDeque<>();
      int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
      qu.add(new Pair(srcx,srcy));
      while(qu.size()>0)
      {
        Pair p=qu.remove();
        for(int d[]:dir)
        {
          int nr=p.x+d[0];
          int nc=p.y+d[1];
          if(nr<0 ||nc<0 ||nr>=A.length ||nc>=A[0].length ||A[nr][nc]==0 ||A[nr][nc]==-1)
            continue;
          if(A[nr][nc]==2)
            return 1;
          A[nr][nc]=-1;
          qu.add(new Pair(nr,nc));
        }

      }
      return 0;

  }
}
