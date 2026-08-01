class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        long lastAvailable[] = new long[n];
        int roomsUsedCount[] = new int[n];
       

        for (int m[] : meetings) {
            int start = m[0];
            int end = m[1];
            boolean found = false;

            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            for (int room = 0; room < n; room++) {
                if (lastAvailable[room] <= start) {
                    found = true;
                    lastAvailable[room] = end;
                    roomsUsedCount[room]++;
                    break;
                }

                if (lastAvailable[room] < earlyEndRoomTime) {
                    earlyEndRoom = room;
                    earlyEndRoomTime = lastAvailable[room];
                }

            }
            if (!found) {
                lastAvailable[earlyEndRoom] += (end - start);
                roomsUsedCount[earlyEndRoom]++;
            }
        }
        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomsUsedCount[room] > maxUse) {
                maxUse = roomsUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}
