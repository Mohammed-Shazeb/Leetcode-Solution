class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gift : gifts) {
            pq.add((long) gift);
        }
        for (int i = 0; i < k; i++) {
            long maxGift = pq.poll(); 
            long reduced = (long) Math.sqrt(maxGift);
            pq.add(reduced);
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
