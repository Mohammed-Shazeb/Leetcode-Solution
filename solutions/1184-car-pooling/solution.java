class Solution {
    class Events {
        int fromAndTo;
        int currentCapacity;

        Events(int fromAndTo, int currentCapacity) {
            this.fromAndTo = fromAndTo;
            this.currentCapacity = currentCapacity;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<Events> pq = new PriorityQueue<>((a, b) -> {
            if (a.fromAndTo == b.fromAndTo) {
                return a.currentCapacity - b.currentCapacity;
            }
            return a.fromAndTo - b.fromAndTo;
        });        
        for(int i=0; i<trips.length; i++) {
            int curr[] = trips[i];
            int numPass = curr[0];
            int start = curr[1];
            int end = curr[2];

            pq.add(new Events(start, numPass));
            pq.add(new Events(end, -numPass));
        }

        int currentPassengers = 0;
        while(!pq.isEmpty()) {
            Events curr = pq.poll();

            currentPassengers += curr.currentCapacity;

            if(currentPassengers>capacity) return false;
        }
        return true;
    }
}
