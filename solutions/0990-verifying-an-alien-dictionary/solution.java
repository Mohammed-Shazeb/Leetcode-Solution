class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Create a mapping from character to its position in 'order'
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i=0; i<words.length-1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            boolean valid = false;
            int n = Math.min(s1.length(), s2.length());

            for(int j=0; j<n; j++) {
                int rank1 = map.get(s1.charAt(j));
                int rank2 = map.get(s2.charAt(j));

                if(rank1<rank2) {
                    valid = true;
                    break;
                } else if(rank1>rank2) {
                    return false;
                }
            }
            if (!valid && s1.length() > s2.length()) return false;
        }
        return true;
    }
}   
