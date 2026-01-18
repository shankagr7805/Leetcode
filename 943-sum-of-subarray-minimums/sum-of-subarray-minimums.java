class Solution {
    private int[] findNSE(int[] arr) {
        int[] nse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = (st.isEmpty()) ? arr.length : st.peek(); 
            st.push(i);
        }
        return nse;
    }
    private int[] findPSE(int[] arr) {
        int[] pse = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = (st.isEmpty()) ? -1 : st.peek(); 
            st.push(i);
        }
        return pse;
    }
    public int sumSubarrayMins(int[] arr) {
        int ans = 0;
        int MOD = 1000000007;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        for(int i=0; i<arr.length; i++) {
            long left = i - pse[i] ;
            long right = nse[i] - i;
            long cal = (left * right * arr[i]) % MOD ;
            ans = (ans + (int) cal) % MOD;
        }
        return ans;
    }
}