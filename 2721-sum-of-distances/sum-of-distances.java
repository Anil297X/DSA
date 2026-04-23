class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            int size = list.size();
            if (size == 1) continue;
            long leftSum = 0;
            long rightSum = 0;
            for (int idx : list) {
                rightSum += idx;
            }
            for (int i = 0; i < size; i++) {
                int index = list.get(i);
                rightSum -= index;
                long leftDist = (long) index * i - leftSum;
                long rightDist = rightSum - (long) index * (size - i - 1);
                result[index] = leftDist + rightDist;
                leftSum += index;
            }
        }
        return result;
    }
}