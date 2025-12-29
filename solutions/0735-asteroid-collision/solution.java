class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            if (curr >= 0) {
                s.push(curr);
            } else {
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(curr)) {
                    s.pop();
                }

                if (!s.isEmpty() && s.peek() == Math.abs(curr)) {
                    s.pop();
                    continue; // negative asteroid destroyed, no need to push
                }

                if (!s.isEmpty() && s.peek() > Math.abs(curr)) {
                    continue; // negative asteroid destroyed, do not push
                }

                s.push(curr); // safe to push if stack empty or top < 0

            }

        }

        int size = s.size();
        int res[] = new int[size];
        int i = 0;

        while (!s.isEmpty()) {
            res[size - 1 - i] = s.pop();
            i++;
        }
        return res;
    }
}
