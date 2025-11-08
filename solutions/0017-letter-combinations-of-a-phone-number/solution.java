class Solution {
    static String[] keypad = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    private void helper(String p, String up, List<String> result){
        if (up.isEmpty()) {
            result.add(p);
            return; 
        }

        int digit = up.charAt(0) - '0';
        String letters = keypad[digit];

        for (char ch : letters.toCharArray()) {
            helper(p + ch, up.substring(1), result);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.isEmpty()) return result;
        helper("", digits,result);
        return result;
        
    }
}
