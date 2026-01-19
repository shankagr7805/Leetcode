import java.util.*;
class Solution {
    private long sumMins(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Smaller Element (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        // Next smaller element.
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * left[i] * right[i];
        }

        return ans;
    }
    private long sumMaxs(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous Greater Element (strictly smaller)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? (i + 1) : (i - st.peek());
            st.push(i);
        }

        st.clear();

        // Next Greater element.
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? (n - i) : (st.peek() - i);
            st.push(i);
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) nums[i] * left[i] * right[i];
        }

        return ans;
    }
    public long subArrayRanges(int[] nums) {
        return (sumMaxs(nums) - sumMins(nums));
    }
}
