class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        // leftSums[k] = all subset sums using k elements from left
        List<List<Integer>> leftSums = new ArrayList<>();
        List<List<Integer>> rightSums = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            leftSums.add(new ArrayList<>());
            rightSums.add(new ArrayList<>());
        }

        generate(left, 0, 0, 0, leftSums);
        generate(right, 0, 0, 0, rightSums);

        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSums.get(i));
        }

        int totalSum = Arrays.stream(nums).sum();
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> L = leftSums.get(k);
            List<Integer> R = rightSums.get(n - k);

            for (int lsum : L) {
                int target = totalSum / 2 - lsum;

                int idx = Collections.binarySearch(R, target);
                if (idx < 0) idx = -idx - 1;

                if (idx < R.size()) {
                    int sum = lsum + R.get(idx);
                    ans = Math.min(ans, Math.abs(2 * sum - totalSum));
                }
                if (idx > 0) {
                    int sum = lsum + R.get(idx - 1);
                    ans = Math.min(ans, Math.abs(2 * sum - totalSum));
                }
            }
        }

        return ans;
    }

    private void generate(
            int[] arr,
            int idx,
            int count,
            int sum,
            List<List<Integer>> res
    ) {
        if (idx == arr.length) {
            res.get(count).add(sum);
            return;
        }
        generate(arr, idx + 1, count, sum, res);
        generate(arr, idx + 1, count + 1, sum + arr[idx], res);
    }
}