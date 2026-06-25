class Tuple {
    int a, b, c;
    Tuple(int _a, int _b, int _c) {
        this.a = _a; this.b = _b; this.c = _c;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length; int m = heights[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.a - y.a);
        int[][] dis = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dis[i][j] = (int) (1e9);
            }
        }
        dis[0][0] = 0;
        pq.add(new Tuple(0, 0, 0));
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!pq.isEmpty()) {
            Tuple it = pq.peek();
            pq.remove();
            int diff = it.a;
            int r = it.b;
            int c = it.c;
            if(r==n-1 && c==m-1) return diff;
            for(int i=0; i<4; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m) {
                    int eff = Math.max(Math.abs(heights[newr][newc] - heights[r][c]), diff);
                    if(eff < dis[newr][newc]) {
                        dis[newr][newc] = eff;
                        pq.add(new Tuple(eff, newr, newc));
                    }
                }
            }
        }
        return 0;
    }
}