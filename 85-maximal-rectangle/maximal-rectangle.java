class Solution {
    private int largestArea(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        int maxArea = 0; int n = arr.length;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int el = st.peek();
                st.pop();
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();

                maxArea = Math.max(maxArea, arr[el] * (nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int el = st.peek();
            st.pop();
            int nse = n;
            int pse = (st.isEmpty()) ? -1 : st.peek();

            maxArea = Math.max(maxArea, arr[el] * (nse-pse-1));
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length; int n = matrix[0].length;
        int[][] preMatrix = new int[m][n];
        for(int i=0; i<n; i++) {
            int preSum = 0;
            for(int j=0; j<m; j++) {  
                preSum = (matrix[j][i] == '1') ? preSum + 1 : 0;
                preMatrix[j][i] = preSum;
            }
        }
        int ans = 0;
        for(int k=0; k<m; k++) {
            ans = Math.max(ans , largestArea(preMatrix[k]));
        }

        return ans;
    }
}