class Solution {
    public String simplifyPath(String path) {
    String [] s=path.split("/");
    Stack<String> stack=new Stack<>();
    for(String a:s){
        if(a.equals(".")||a.equals(""))continue;
        else if(a.equals("..")){
            if(!stack.isEmpty()){
                stack.pop();
                continue;
            }
        }
        else{
            stack.push(a);
        }
    }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir); } 
        return result.length() == 0 ? "/" : result.toString();
    }
}