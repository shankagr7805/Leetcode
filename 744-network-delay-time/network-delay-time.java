class Pair {
    int a; int b;
    Pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        } 
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.b - y.b);
        pq.add(new Pair(k, 0));
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        while(!pq.isEmpty()) {
            int node = pq.peek().a;
            int t = pq.peek().b;
            pq.remove();
            if(t > time[node]) continue;
            for(Pair it : adj.get(node)) {
                int v = it.a;
                int ti = it.b;
                if(t + ti < time[v]) {
                    time[v] = t + ti;
                    pq.add(new Pair(v, time[v]));
                }
            }
        }
        int ans =0;
        for(int i=1; i<=n; i++) {
            if(time[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}