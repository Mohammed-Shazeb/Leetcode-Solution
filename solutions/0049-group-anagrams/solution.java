class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] ch = word.toCharArray(); // convert to char array
            Arrays.sort(ch);
            String sorted = new String(ch);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(word);
        }

        for (List<String> group : map.values()) {
            list.add(group);
        }
        return list;
    }
}
