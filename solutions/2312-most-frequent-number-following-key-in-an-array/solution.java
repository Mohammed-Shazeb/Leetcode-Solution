class Solution {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=1; i<nums.length; i++) {
            if(nums[i-1] == key) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        
        int maxKey = 0;
        int maxValue = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}
