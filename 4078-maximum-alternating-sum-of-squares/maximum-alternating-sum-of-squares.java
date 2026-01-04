class Solution {
    public long maxAlternatingSum(int[] nums) {
        if(nums.length==1) return nums[0]*nums[0];
        long[] a=new long[nums.length];
        for(int i=0;i<nums.length;i++){
            a[i]=nums[i]*nums[i];
        }
        Arrays.sort(a);
        int i=0,j=a.length-1;
        long sum=0;
        while(i<=j){
            sum+=a[j];
            sum-=a[i];
            j--;
            i++;
        }
        if(a.length%2==1){
            sum+=a[a.length/2];
        }
        return sum;
    }
}