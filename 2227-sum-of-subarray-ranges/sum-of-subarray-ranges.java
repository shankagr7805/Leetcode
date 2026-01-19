import java.util.*;
class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        long sumMax = 0;
        long sumMin = 0;

        // -------- SUM OF SUBARRAY MINIMUMS --------
        Stack<Integer> st = new Stack<>();
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        // Previous smaller (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            leftMin[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        // Next smaller or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            rightMin[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            sumMin += (long) nums[i] * leftMin[i] * rightMin[i];
        }

        // -------- SUM OF SUBARRAY MAXIMUMS --------
        st.clear();
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Previous greater (strictly greater)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            leftMax[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        // Next greater or equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            rightMax[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            sumMax += (long) nums[i] * leftMax[i] * rightMax[i];
        }

        return sumMax - sumMin;
    }
}
