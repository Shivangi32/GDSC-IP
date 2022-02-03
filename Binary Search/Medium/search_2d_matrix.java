class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n=matrix[0].length;
        int m=matrix.length;
        int j=n-1;
        int i=0;
        while(i<m && j>=0)
        {
            if(matrix[i][j]==target)
                return true;
            if(matrix[i][j]<target)
                i++;
            else
                j--;
        }
        return false;
    }
}