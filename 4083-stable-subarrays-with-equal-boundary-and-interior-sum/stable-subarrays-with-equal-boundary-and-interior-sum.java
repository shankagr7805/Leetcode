class Solution {
    public long countStableSubarrays(int[] c) {
        int n = c.length;
        long ans = 0;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + c[i];
        }

        // value -> (prefix value -> count)
        Map<Integer, Map<Long, Integer>> map = new HashMap<>();

        for (int r = 2; r < n; r++) {
            int l = r - 2;

            // add l as possible start
            map.putIfAbsent(c[l], new HashMap<>());
            Map<Long, Integer> inner = map.get(c[l]);
            long key = prefix[l + 1];
            inner.put(key, inner.getOrDefault(key, 0) + 1);

            // check for r
            int val = c[r];
            if (map.containsKey(val)) {
                long need = prefix[r] - val;
                ans += map.get(val).getOrDefault(need, 0);
            }
        }

        return ans;
    }
}