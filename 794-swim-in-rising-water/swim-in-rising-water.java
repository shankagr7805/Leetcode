class Pair {
    int a;
    int b;
    int c;
    Pair(int _a, int _b, int _c) {
        this.a = _a;
        this.b = _b;
        this.c = _c;
    }
}
class Solution
{
    public int swimInWater(int[][] grid) 
    {
        int n = grid.length;
        int[][] dis = new int[n][n];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.a - y.a);
        for(int i=0; i<n; i++) Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[0][0] = 0;
        pq.add(new Pair(grid[0][0], 0, 0));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(pq.size() != 0) {
            int t = pq.peek().a;
            int r = pq.peek().b;
            int c = pq.peek().c;
            pq.remove();
            
            if(r==n-1 && c==n-1) return t;

            for(int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nt = Math.max(t, grid[nr][nc]);
                    if(nt < dis[nr][nc]) {
                        dis[nr][nc] = nt;
                        pq.add(new Pair(nt, nr, nc));
                    }
                }
            }
        }
        return -1;
    }
}