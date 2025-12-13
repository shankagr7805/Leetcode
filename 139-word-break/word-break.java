class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        int len = 0;
        for(String str : wordDict){
            len = Math.max(str.length(),len);
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=i-1;j>=Math.max(0,i-len);j--){
                if(wordDict.contains(s.substring(j,i))){
                    if(dp[j]==true){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[dp.length-1];
        
    }
}