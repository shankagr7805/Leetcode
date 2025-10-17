class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char b : s.toCharArray()) {
            if(b == '(' || b == '{' || b == '[') {
                stack.push(b);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();

                if ((b == ')' && top != '(') ||
                    (b == '}' && top != '{') ||
                    (b == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}