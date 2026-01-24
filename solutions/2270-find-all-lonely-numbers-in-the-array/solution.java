
class Solution {
    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getKey(); 
            if(entry.getValue() == 1 && !map.containsKey(val-1) && !map.containsKey(val+1)) {
                list.add(val);
            }
        }
        return list;
    }
}
