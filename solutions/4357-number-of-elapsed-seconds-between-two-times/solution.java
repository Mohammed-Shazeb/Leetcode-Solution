class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        return toSeconds(endTime) - toSeconds(startTime);
    }

    private int toSeconds(String time) {
        String[] parts = time.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        int second = Integer.parseInt(parts[2]);

        return hour * 3600 + minute * 60 + second;
    }
}
