class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        int buffer[][] = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                buffer[i][j] = grid[i][j];
                //left
                if(j>0){
                    buffer[i][j] += buffer[i][j-1]; 
                }

                //top
                if(i>0){
                    buffer[i][j] += buffer[i-1][j]; 
                }

                //subtracting diagonal
                if(i>0 && j>0){
                    buffer[i][j] -= buffer[i-1][j-1]; 
                }

                // check condition
                if(buffer[i][j] <= k){
                    count++;
                }
            }
        }
        return count;
    }
}