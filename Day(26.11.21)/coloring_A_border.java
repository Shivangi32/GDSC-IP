class Solution {
    
    public int help(int[][] grid,int i,int j,int val,int color,boolean visited[][]){
        
       
        if(i<0 || j<0 || i==grid.length || j==grid[0].length)
            return 0;
         if(visited[i][j]==true)
            return 1;
        if(grid[i][j]!=val)
            return 0;
        visited[i][j]=true;
        int faith=0;
        faith+=help(grid,i,j+1,grid[i][j],color,visited); //right
        faith+=help(grid,i,j-1,grid[i][j],color,visited); //left
        faith+=help(grid,i-1,j,grid[i][j],color,visited); //up
        faith+=help(grid,i+1,j,grid[i][j],color,visited); //down
        System.out.println(i+" "+j+": "+faith);
        if(faith<4)
            grid[i][j]=color;
        return 1;
        
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        help(grid,row,col,grid[row][col],color,visited);
        return grid;
    }
}