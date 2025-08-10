class Solution {
    public int maxCap(int[] weights) {
        int sum = 0;
        for(int i=0; i<weights.length; i++) {
            sum += weights[i];
        }
        return sum ;
    }
    public int heaviest(int[] weights) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<weights.length; i++) {
           if(weights[i] > max) {
            max = weights[i] ;
           }
        }
        return max ;
    }
    public boolean canbeShipped(int[] weights, int days, int cap) {
        int days_taken = 1; int sum = 0;
        for(int i=0; i<weights.length; i++) {
            if(sum + weights[i] > cap) {
                days_taken++ ;
                sum = 0;
            }
            sum += weights[i];
        }
        if(days_taken <= days) {
            return true;
        } 
        return false ;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low = heaviest(weights);
        int high = maxCap(weights);
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            boolean poss = canbeShipped(weights, days, mid);

            if(poss) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}