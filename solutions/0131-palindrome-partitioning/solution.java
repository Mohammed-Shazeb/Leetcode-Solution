class Solution {
    private void backtrack(String s, int index, List<List<String>> result, List<String> list) {
        if(index == s.length()) {
            result.add(new ArrayList<>(list));
        }

        for(int i=index; i<s.length(); i++) {
            String substring = s.substring(index, i+1);

            if(isPalindrome(substring)) {
                list.add(substring);
                backtrack(s, i+1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(s, 0, result, list);
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
