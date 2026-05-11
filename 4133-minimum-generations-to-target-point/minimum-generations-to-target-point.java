class Solution {
    public int minGenerations(int[][] points, int[] target) {
        Set<Integer> cs = new HashSet<>();
        int trg = encode(target[0], target[1], target[2]);
        for(int[] p : points) {
            int val = encode(p[0], p[1], p[2]);
            if (val == trg) {
                return 0;
            }
            cs.add(val);
        }
        if(cs.size() < 2) {
            return -1;
        }
        int k = 0;
        while(true) {
            k++;
            Set<Integer> nB = new HashSet<>();
            List<Integer> list = new ArrayList<>(cs);
            boolean added = false;

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    int p1 = list.get(i);
                    int p2 = list.get(j);
                    
                    int x1 = p1 / 49, y1 = (p1 / 7) % 7, z1 = p1 % 7;
                    int x2 = p2 / 49, y2 = (p2 / 7) % 7, z2 = p2 % 7;
                    
                    int nx = (x1 + x2) / 2;
                    int ny = (y1 + y2) / 2;
                    int nz = (z1 + z2) / 2;
                    
                    int newVal = encode(nx, ny, nz);
                    
                    if (newVal == trg) {
                        return k;
                    }
                    
                    if (!cs.contains(newVal)) {
                        if (nB.add(newVal)) {
                            added = true;
                        }
                    }
                }
            }
            if (!added) {
                return -1;
            }
            
            cs.addAll(nB);
            
            if (cs.size() >= 343) {
                if (!cs.contains(trg)) {
                    return -1;
                }
            }
        }
    }
    private int encode(int x, int y, int z) {
        return x * 49 + y * 7 + z;
    }
}
