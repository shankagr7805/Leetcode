class Solution {
    public long maxAlternatingSum(int[] a) {
        int n = a.length;
        for(int i=0; i<n; i++) {
            if(a[i]<0) {
                a[i] = -a[i];
            }
        }
        Arrays.sort(a);
        int l = 0; int r = n-1;
        long sum = 0;

        while(l<=r) {
            if(l<r) {
                sum += a[r]*a[r];
                sum -= a[l]*a[l];
            } else if(l==r) {
                sum += a[r]*a[r];
            }
            l++; 
            r--;
        }
        return sum;
    }
}