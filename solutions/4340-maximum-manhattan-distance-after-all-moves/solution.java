class Solution {
    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int wildcards = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'R') x++;
            else if (ch == 'L') x--;
            else wildcards++;
        }

        return Math.abs(x) + Math.abs(y) + wildcards;
    }
}
