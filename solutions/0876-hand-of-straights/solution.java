class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int remaining = n;
        int i =0;

        while (remaining > 0) {
            
             while (freq.get(hand[i]) == 0) {
                i++;
            }

            int start = hand[i];

            for (int x = start; x < start + groupSize; x++) {
                if (!freq.containsKey(x) || freq.get(x) == 0) {
                    return false;
                }
                freq.put(x, freq.get(x) - 1);
            }
            remaining -= groupSize;
        }
        return true;
    }
}
