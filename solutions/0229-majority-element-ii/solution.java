class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 1;
        int count1 = 0, count2 = 0;
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == candidate1)
                count1++;
            else if (num == candidate2)
                count2++; 
        }
        if (count1 > n / 3)
            list.add(candidate1);

        if (count2 > n / 3 && candidate2 != candidate1)
            list.add(candidate2);

        return list;
    }
}

