class Solution {
    
    public class Pair{
        int x;
        int y;
        
        public Pair(int x,int y)
        {
            this.x=x;
            this.y=y;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m=mat.length;
        int n=mat[0].length;
        int level[][]=new int[m][n];
        Queue<Pair>qu=new ArrayDeque<>();
        Queue<Pair>helper=new ArrayDeque<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                    qu.add(new Pair(i,j));
            }
        }
        Pair dir[]=new Pair[4];
        dir[0]=new Pair(-1,0);
        dir[1]=new Pair(0,1);
        dir[2]=new Pair(1,0);
        dir[3]=new Pair(0,-1);
        int lvl=0;
        while(qu.size()>0)
        {
            while(qu.size()>0)
            {
              Pair p=qu.remove();
              int cr=p.x,cc=p.y;
              if(mat[cr][cc]==-1)
                   continue;
              level[cr][cc]=lvl;
              mat[cr][cc]=-1;
              for(Pair d:dir)
              {
                int nr=cr+d.x;
                int nc=cc+d.y;
                if(nr<0 || nc<0 || nr>=m || nc>=n || mat[nr][nc]==-1)
                    continue;
                helper.add(new Pair(nr,nc));
              }
            }
            lvl++;
            qu=helper;
            helper=new ArrayDeque<>();
        }
        return level;
    }
}