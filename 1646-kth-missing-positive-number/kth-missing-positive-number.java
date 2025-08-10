class Solution {
    private int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    public int findKthPositive(int[] arr, int k) {
        int low = 1;
        int high = arr[arr.length - 1] + k ;
        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            int count = upperBound(arr, mid);
            int missing = mid - count;

            if(missing < k) {
               low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}