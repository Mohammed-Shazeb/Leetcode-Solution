class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;

        // Calculate sum of weights and max single weight
        for (int w : weights) {
            sum += w;
            max = Math.max(max, w);
        }

        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = low + (high-low)/2;

            int numDay = daysNeeded(weights, mid);

            if(numDay <= days) {
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return low;
    }

    private int daysNeeded(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                days++;        // need a new day
                load = w;      // start with current package
            } else {
                load += w;
            }
        }
        return days;
    }
}

