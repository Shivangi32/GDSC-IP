class Solution {
    
    public void getComp(char arr[][],int i,int j,boolean visited[][])
    {
        int m=arr.length;
        int n=arr[0].length;
        if(i<0 || j<0 || i>=m || j>=n || arr[i][j]=='0' || visited[i][j]==true)
            return;

        visited[i][j]=true;
        getComp(arr,i+1,j,visited);
        getComp(arr,i-1,j,visited);
        getComp(arr,i,j+1,visited);
        getComp(arr,i,j-1,visited);
        
    }
    public int numIslands(char[][] grid) {
        
        int count=0;
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(visited[i][j]==false && grid[i][j]=='1')
                {
                    getComp(grid,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }
}