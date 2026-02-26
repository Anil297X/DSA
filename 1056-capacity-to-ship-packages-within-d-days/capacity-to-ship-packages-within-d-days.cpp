class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        int n = weights.size();

        int low = *max_element(weights.begin(), weights.end());
        int high = 0;

        for (int i = 0; i < n; i++){
            high += weights[i];
        }

        while(low < high){
            int mid = low + (high - low)/2;
            int limitCheck = 0;
            int tillDay = 1;
            for (int j = 0; j < n; j++) {
                if (limitCheck + weights[j] > mid) {
                    tillDay++;
                    limitCheck = 0;
                }
                limitCheck += weights[j];
            }
            if(tillDay > days){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return high;
    }
};