class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> nG = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int x : nums2) {
            while (!st.isEmpty() && st.peek() < x) {
                nG.put(st.pop(), x);
            }
            st.push(x);
        }
        int n = nums1.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nG.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}