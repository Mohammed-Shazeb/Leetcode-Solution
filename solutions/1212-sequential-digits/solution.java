class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String str = "123456789";
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                int num = Integer.parseInt(str.substring(i, j));
                if(low<=num && num<=high) list.add(num);
            }
        }
        Collections.sort(list);
        return list; 
    }
}
