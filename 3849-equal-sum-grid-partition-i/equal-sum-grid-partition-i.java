class Solution {
    public boolean canPartitionGrid(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        
        long totalsum = 0;
        
        //Total Sum
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                totalsum += grid[i][j];
            }
        }

        //check total sum
        if(totalsum % 2 != 0) return false;
        long target = totalsum/2;

        //prefix sum for horizontal cuts 
        long prefixsum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                prefixsum += grid[i][j];
            }
            if( prefixsum == target) return true;
        }

         //prefix sum for vertical cuts 
        prefixsum = 0;
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                prefixsum += grid[i][j];
            }
            if( prefixsum == target) return true;
        }
        
        return false;

    }
}