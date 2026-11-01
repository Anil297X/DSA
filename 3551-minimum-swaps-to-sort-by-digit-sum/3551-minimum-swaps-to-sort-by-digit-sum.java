class Solution {
    static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = digitSum(nums[i]);
            map.computeIfAbsent(key, k -> new ArrayList<>())
               .add(nums[i]);
        }
        int idx = 0;
        for (int key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            Collections.sort(list);
            for (int num : list) {
                temp[idx++] = num;
            }
        }
        HashMap<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(temp[i], i);
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int j = i;
            int cycleSize = 0;
            while (!visited[j]) {
                visited[j] = true;
                cycleSize++;
                j = pos.get(nums[j]);
            }
            swaps += cycleSize - 1;
        }
        return swaps;
    }
}
