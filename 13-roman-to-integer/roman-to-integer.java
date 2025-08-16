class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        m.put('I' , 1);
        m.put('V' , 5);
        m.put('X' , 10);
        m.put('L' , 50);
        m.put('C' , 100);
        m.put('D' , 500);
        m.put('M' , 1000);
        int num = 0;

        if(s.length() == 1) {
            num += m.get(s.charAt(0));
            return num;
        }
        
        for(int i=s.length()-1; i>0; i--) {
            if(m.get(s.charAt(i)) > m.get(s.charAt(i-1))) {
                num += m.get(s.charAt(i)) - m.get(s.charAt(i-1));
                i--;
            } else {
                num += m.get(s.charAt(i));
            }
        }
        if(m.get(s.charAt(1)) <= m.get(s.charAt(0))) {
            num += m.get(s.charAt(0));
        }
        return num ;
    }
}