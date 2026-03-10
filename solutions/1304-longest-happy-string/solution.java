class Solution {
    class Freq {
        int count;
        char character;

        Freq(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Freq> pq = new PriorityQueue<>((x, y) -> y.count - x.count);
        if (a > 0) pq.add(new Freq(a, 'a'));
        if (b > 0) pq.add(new Freq(b, 'b'));
        if (c > 0) pq.add(new Freq(c, 'c'));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            Freq firstMax = pq.poll();
            int count = firstMax.count;
            char ch = firstMax.character;

            int len = sb.length();

            if (len >= 2 && sb.charAt(len - 1) == ch && sb.charAt(len - 2) == ch) {

                if (pq.isEmpty())
                    break;

                Freq secondMax = pq.poll();
                int secondCount = secondMax.count;
                char secondCh = secondMax.character;

                sb.append(secondCh);
                secondCount--;

                if (secondCount > 0)
                    pq.add(new Freq(secondCount, secondCh));

            } else {
                sb.append(ch);
                count--;
            }
            if (count > 0)
                pq.add(new Freq(count, ch));
        }
        return sb.toString();
    }
}
