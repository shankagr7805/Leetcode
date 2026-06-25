class Pair {
    int a; int b;
    Pair(int _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
}
class Tuple {
    int a; int b; int c;
    Tuple(int _a, int _b, int _c) {
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));
        dis[src] = 0;
        while(!q.isEmpty()) {
            int node = q.peek().b;
            int d = q.peek().c;
            int stops = q.peek().a;
            q.remove();
            if(stops > k) continue;

            for(Pair it:adj.get(node)) {
                int v = it.a;
                int wt = it.b;
                if(d + wt < dis[v] && stops<=k) {
                    dis[v] = d + wt;
                    q.add(new Tuple(stops + 1, v, dis[v]));
                }
            }
        }
        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}