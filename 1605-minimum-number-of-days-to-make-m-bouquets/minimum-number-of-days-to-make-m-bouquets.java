class Solution {
    public int minimum (int[] bloomDay) {
        int n = bloomDay.length ;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            if(bloomDay[i] < min) {
                min = bloomDay[i];
            }
        }
        return min;
    }
    public int maximum (int[] bloomDay) {
        int n = bloomDay.length ;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            if(bloomDay[i] > max) {
                max = bloomDay[i];
            }
        }
        return max;
    }
    public boolean canMake(int[] bloomDay , int m , int k , int days) {
        int count = 0; int bonq = 0;
        for(int day : bloomDay) {
            if(day <= days) {
                count++;
                if(count == k) {
                    bonq++;
                    count = 0;
                } 
            } else {
                count = 0;
            }
        }

        if(bonq >= m) {
            return true;
        } 

        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length ;
        int low = minimum(bloomDay) ;
        int high = maximum(bloomDay) ;
        int ans = -1;

        if(n < m * k) {
            return -1 ;
        }
        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            if(canMake(bloomDay , m , k , mid)) {
                ans = mid ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans ;
    }
}