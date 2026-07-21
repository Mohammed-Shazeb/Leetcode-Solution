class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String str = "1" + s + "1";

        List<Integer> count = new ArrayList<>();
        List<Character> chars = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);
            int j = i;

            while (j < str.length() && str.charAt(j) == ch) {
                j++;
            }

            chars.add(ch);
            count.add(j - i);

            i = j;
        }
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            }
        }

        int maxGain = 0;

        for (int k = 0; k < chars.size() - 2; k++) {
            if (chars.get(k) == '0' && chars.get(k + 1) == '1' && chars.get(k + 2) == '0') {
                int gain = count.get(k) + count.get(k + 2);

                maxGain = Math.max(maxGain, gain);
            }
        }

        return ones + maxGain;
    }
}
