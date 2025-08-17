class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int total = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26]; 

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int maxFreq = 0, minFreq = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {
                        maxFreq = Math.max(maxFreq, f);
                        minFreq = Math.min(minFreq, f);
                    }
                }

                total += (maxFreq - minFreq);
            }
        }

        return total;
    }
}