class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> s = new Stack<>();
        int n = position.length;

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];

        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i][0];
            s.push((double) (target - arr[i][0]) / arr[i][1]);

            if (s.size() >= 2) {
                double firstPeek = s.pop();
                double secondPeek = s.peek();
    
                if (firstPeek > secondPeek) {
                    s.push(firstPeek);
                }
            }
        }
        return s.size();
    }
}
