class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        if (m==0) return false;
        int start = 0,end = m*n-1;
        while(start<=end){
            int mid = (start+end)/2;
            int element = matrix[mid/n][mid%n];
            if(target==element){
                return true;
            }
            else if(target < element){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return false;

    }
};