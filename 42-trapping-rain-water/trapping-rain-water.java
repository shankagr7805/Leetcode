class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n==1 || n==2) return 0;

        int[] l_mx = new int[n];
        int[] r_mx = new int[n];

        l_mx[0] = height[0];
        for(int i=1; i<n; i++) {
            l_mx[i] = Math.max(l_mx[i-1], height[i]);
        } 
        r_mx[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
            r_mx[i] = Math.max(r_mx[i+1], height[i]);
        } 
        int w = 0;
        for(int i=0; i<n; i++) {
            w += Math.min(l_mx[i], r_mx[i]) - height[i];
        }

        return w;
    }
}