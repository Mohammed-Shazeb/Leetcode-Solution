class Solution {
    public boolean isScrambleMemoMap(String s1, String s2, Map<String, Boolean> memo) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + "," + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (isScrambleMemoMap(s1.substring(0, i), s2.substring(0, i), memo) && isScrambleMemoMap(s1.substring(i), s2.substring(i), memo)) {
                memo.put(key, true);
                flag = true;
                break;
            }
            if (isScrambleMemoMap(s1.substring(0, i), s2.substring(n - i), memo) && isScrambleMemoMap(s1.substring(i), s2.substring(0, n - i), memo)) {
                memo.put(key, true);
                flag = true;
                break;
            }
        }
        memo.put(key, flag);
        return flag; 
    }


    public boolean isScramble(String s1, String s2) {
        HashMap<String, Boolean> memo = new HashMap<>();
        return isScrambleMemoMap(s1,s2,memo);

    }
}
