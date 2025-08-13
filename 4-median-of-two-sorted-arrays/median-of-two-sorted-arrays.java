class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        int m = nums1.length; int n = nums2.length;
        int i=0; int j=0;
        
        while(i<m && j<n) {
            if(nums1[i] < nums2[j]) {
                arr.add(nums1[i]);
                i++;
            } else {
                arr.add(nums2[j]);
                j++;
            }
        }
        while(i<m) {
            arr.add(nums1[i]);
            i++;
        } 
        while(j<n) {
            arr.add(nums2[j]);
            j++;
        }
        double ans = 0.0; int a = arr.size() / 2 ;
        if(arr.size()%2 != 0) {
            ans = arr.get(a);
        } else {
            ans = (double) (arr.get(a) + arr.get(a-1)) / 2 ;
        }

        return ans ;
    }
}