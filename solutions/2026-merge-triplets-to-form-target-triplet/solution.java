class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean first = false;
        boolean second = false;
        boolean third = false;

        for (int[] t : triplets) {

            if (t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]) {
                continue;
            }

            if (t[0] == target[0]) first = true;
            if (t[1] == target[1]) second = true;
            if (t[2] == target[2]) third = true;
        }

        return first && second && third;
    }
}
