class Solution {
    public int evalRPN(String[] tokens) {
        int[] s = new int[tokens.length];
        int i = 0;

        for (String token : tokens) {
            switch (token) {
                case "+":
                    s[i - 2] = s[i - 2] + s[i - 1];
                    i--;
                    break;

                case "*":
                    s[i - 2] = s[i - 2] * s[i - 1];
                    i--;
                    break;

                case "-":
                    s[i - 2] = s[i - 2] - s[i - 1];
                    i--;
                    break;

                case "/":
                    s[i - 2] = s[i - 2] / s[i - 1];
                    i--;
                    break;

                default:
                    s[i++] = Integer.parseInt(token);
            }
        }

        return s[i - 1];

    }
}
