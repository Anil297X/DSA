class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;
        int[] arr = new int[total];
        int index = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[index++] = grid[i][j];
            }
        }
        int[] rotated = new int[total];
        for(int i=0;i<total;i++){
            rotated[(i+k)%total] = arr[i];
        }
        List<List<Integer>> ans = new ArrayList<>();
        index = 0;
        for(int i=0;i<m;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(rotated[index++]);
            }
            ans.add(row);
        }
        return ans;
    }
}