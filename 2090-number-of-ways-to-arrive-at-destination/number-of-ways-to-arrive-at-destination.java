class Pair {
    int a; long b;
    Pair(int _a, long _b) {
        this.a = _a;
        this.b = _b;
    }
}
class Solution {
    private static int MOD = 1_000_000_007 ;
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }
        long[] time = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.b, y.b));
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()) {
            int node = pq.peek().a;
            long t = pq.peek().b;
            pq.remove();
            if(t > time[node]) continue;

            for(Pair it : adj.get(node)) {
                int v = it.a;
                long ti = it.b;
                if(t + ti < time[v]) {
                    time[v] = t + ti;
                    ways[v] = ways[node];
                    pq.add(new Pair(v, time[v]));
                } else if(t + ti == time[v]) {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return ways[n-1];
    }
}