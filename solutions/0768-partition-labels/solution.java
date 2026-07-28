class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = last[s.charAt(start) - 'a'];
        while (start < s.length()) {
            for (int i = start; i <= end; i++) {
                end = Math.max(end, last[s.charAt(i) - 'a']);
            }
            list.add(end - start + 1);
            start = end + 1;
            if (start < s.length()) {
                end = last[s.charAt(start) - 'a'];
            }
        }
        return list;
    }
}
