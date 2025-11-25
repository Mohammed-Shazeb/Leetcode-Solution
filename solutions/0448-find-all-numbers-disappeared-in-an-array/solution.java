class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int freq[] = new int[n + 1];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }

        for(int i=1; i<freq.length; i++){
            if(freq[i] == 0){
                list.add(i);
            }
        }
        return list;

    }
}
