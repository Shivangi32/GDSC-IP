class Solution {
    
    public void getComp(char grid[][],int i,int j)
    {
        int m=grid.length;
        int n=grid[0].length;
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0')
            return;

        grid[i][j]='0';
        getComp(grid,i+1,j);
        getComp(grid,i-1,j);
        getComp(grid,i,j+1);
        getComp(grid,i,j-1);
        
    }
    public int numIslands(char[][] grid) {
        
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    getComp(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}