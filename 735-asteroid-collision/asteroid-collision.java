class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                int top = st.peek();

                if (Math.abs(top) < Math.abs(a)) {
                    st.pop();
                    continue;
                } 
                else if (Math.abs(top) == Math.abs(a)) {
                    st.pop();
                    destroyed = true;
                    break;
                } 
                else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}