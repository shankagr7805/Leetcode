class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(num.length() == k) {
            return "0";
        }
        for(char c : num.toCharArray()) {
            while(!st.isEmpty() && st.peek() > c && k>0) {
                System.out.println("peek: " + st.peek());
                st.pop();
                k--;
            }  
            st.push(c);
            System.out.println("after push peek: " + st.peek());
        }
        while(k>0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}