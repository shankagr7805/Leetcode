class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();
        int l = 0, r = 0, mx = 0;

        while (r < fruits.length) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);
            if (mp.size() <= 2) {
                mx = Math.max(mx, r - l + 1);
            } else {
                while(mp.size() > 2) {
                    mp.put(fruits[l], mp.get(fruits[l]) - 1);
                    if (mp.get(fruits[l]) == 0) {
                        mp.remove(fruits[l]);
                    }
                    l++;
                } 
            }
            r++;
        }
        return mx;
    }
}