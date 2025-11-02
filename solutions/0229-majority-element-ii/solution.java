class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if(map.containsKey(curr)){
                map.put(curr,map.get(curr)+1);
            }else{
                map.put(curr,1);
            }
        }
        int threshold = nums.length / 3;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > threshold) {
                list.add(entry.getKey());
            }
        }
        return list;
    }
}
