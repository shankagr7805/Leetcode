class Solution {
    private int histogramMaxArea(int[] arr) {
        int n = arr.length;
        int maxA = 0;
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<=n; i++) {
            while(!st.isEmpty() && (i == n || arr[i] <= arr[st.peek()])) {
                int h = arr[st.peek()];
                st.pop();
                int w = 0;
                if(st.isEmpty()) w = i;
                else w = i - st.peek() - 1;
                maxA = Math.max(maxA, h*w);
            }
            if(i<n) st.push(i);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n]; int maxA = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == '1') arr[j]++;
                else arr[j] = 0;
            }
            int area = histogramMaxArea(arr);
            maxA = Math.max(maxA, area);
        }

        return maxA;
    }
}