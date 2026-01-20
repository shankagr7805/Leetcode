class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0; int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int el = st.peek(); 
                st.pop();
                int nse = i;
                int pse = (st.isEmpty()) ? -1 : st.peek();

                maxArea = Math.max(maxArea , heights[el] * (nse - pse -1));
            }
            st.push(i);
        }
        while(!st.isEmpty()) {
            int nse = n;
            int el = st.peek();
            st.pop();
            int pse = (st.isEmpty()) ? -1 : st.peek();

            maxArea = Math.max(maxArea , heights[el] * (nse - pse -1));
        }
        return maxArea;
    }
}