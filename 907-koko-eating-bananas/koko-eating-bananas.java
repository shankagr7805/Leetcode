class Solution {
    public long func(int[] piles, int per_hr) {
        int n = piles.length;
        long total_hrs = 0;
        for(int i=0; i<n; i++) {
            total_hrs += (int) Math.ceil((double)piles[i] / (double)per_hr) ;
        }
        return total_hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1 ; int max = piles[0];
        for(int i=1; i<n; i++) {
            if(piles[i] > max) {
                max = piles[i];
            }
        }
        int high = max;

        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            long total = func(piles , mid);

            if(total <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;  
            }
        }

        return low ;
    }
}