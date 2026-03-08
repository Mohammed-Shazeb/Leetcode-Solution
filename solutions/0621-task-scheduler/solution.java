class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int max = 0;
        int maxCount = 0; //Tasks with max frequency
        for(char task : tasks) {
            counter[task - 'A']++;
            if(max == counter[task - 'A']) {
                maxCount++;
            }
            else if(max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        int partCount = max-1;  //If A appears 3 times, there are 2 gaps between them.
        int partLength = n - (maxCount-1); //Each gap must be at least n long.
        int emptySlots = partCount * partLength; //There are 4 “slots” we need to fill with other tasks (or idle time).
        int availableTasks = tasks.length - max * maxCount;//How many other tasks we have to fill empty slots?
        int idles = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + idles;
    }
}
