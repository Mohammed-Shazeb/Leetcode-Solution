class DetectSquares {
    Map<Integer, Map<Integer, Integer>> freq;
    public DetectSquares() {
        freq = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        freq.putIfAbsent(x, new HashMap<>());

        Map<Integer, Integer> yMap = freq.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        int ans = 0;

        for(int x2:freq.keySet()) {
            for(int y2:freq.get(x2).keySet()) {
                int dx = Math.abs(x - x2);
                int dy = Math.abs(y - y2);

                // Must form a non-zero diagonal of a square
                if (dx == 0 || dx != dy) {
                    continue;
                }

                // Other two corners
                int otherY1 = y2;  // (x, y2)
                int otherX2 = x2;  // (x2, y)

                // Check whether both corners exist
                if (freq.containsKey(x) && freq.get(x).containsKey(otherY1) &&
                    freq.containsKey(otherX2) && freq.get(otherX2).containsKey(y)) {

                    int f1 = freq.get(x2).get(y2);
                    int f2 = freq.get(x).get(y2);
                    int f3 = freq.get(x2).get(y);

                    ans += f1 * f2 * f3;
                }
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
