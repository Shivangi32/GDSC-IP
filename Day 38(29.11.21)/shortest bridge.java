class Solution {
    public class Pair {
    int x;
    int y;

    Pair(int row, int col) {
      x = row;
      y = col;
    }
  }

  public  int dir[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  public void dfs(int i, int j, Queue<Pair>qu, int[][] A)
  {
    if (A[i][j] == -1)
      return;
    A[i][j] = -1;
    qu.add(new Pair(i, j));
    for (int d[] : dir)
    {
      int nr = i + d[0];
      int nc = j + d[1];
      if (nr < 0 || nc < 0 || nr >= A.length || nc >= A[0].length || A[nr][nc] == -1 || A[nr][nc] == 0)
        continue;
      dfs(nr, nc, qu, A);
    }
  }
  public int shortestBridge(int[][] A) {

    int m = A.length;
    int n = A[0].length;
    Queue<Pair>qu = new ArrayDeque<>();
    Queue<Pair>helper = new ArrayDeque<>();
    for (int i = 0; i < m; i++)
    {
      boolean flag = false;
      for (int j = 0; j < n; j++)
      {
        if (A[i][j] == 1)
        {
          dfs(i, j, qu, A);
          flag = true;
          break;
        }
      }
      if (flag == true)
        break;
    }
    int lvl=0;
    while (qu.size() > 0)
    {
        boolean flag=false;
      while (qu.size() > 0)
      {
        Pair p = qu.remove();
        for (int d[] : dir)
        {
          int nr = p.x + d[0];
          int nc = p.y + d[1];
          if (nr < 0 || nc < 0 || nr >= A.length || nc >= A[0].length || A[nr][nc] == -1 )
            continue;
          if(A[nr][nc] == 0)
          helper.add(new Pair(nr, nc));
          if(A[nr][nc] == 1)
          {
              flag=true;
              break;
          }
        }
      }
      lvl++;
      if(flag==true)
        break;
      qu = helper;
      helper = new ArrayDeque<>();

    }
    if(lvl==1)
      return 0;
    return lvl-1;
  }
}