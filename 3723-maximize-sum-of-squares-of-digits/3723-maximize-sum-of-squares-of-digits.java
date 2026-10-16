class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder ans = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (sum >= i && ans.length() < num) {
                ans.append(String.valueOf(i));
                sum = sum - i;

                if (sum == 0 && ans.length() == num) {
                    return ans.toString();
                }
            }
        }

        return "";
    }
}