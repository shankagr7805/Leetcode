class Solution {
    public long subArrayRanges(int[] arr) {
        long sum = 0; int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();

        //Subtracting sum of 
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])){
                int el = stack.pop();
                int pse = (stack.isEmpty())? -1 : stack.peek();
                int nse = i;
                sum -= (long)arr[el] * (el - pse) * (nse - el);
            }stack.push(i);
        }stack.clear();
        for(int i = 0; i <= n; i++){
            while(!stack.isEmpty() && (i == n || arr[stack.peek()] < arr[i])){
                int el = stack.pop();
                int pse = (stack.isEmpty())? -1 : stack.peek();
                int nse = i;
                sum += (long)arr[el] * (el - pse) * (nse - el);
            }stack.push(i);
        }return sum;
    }
}