class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!dq.isEmpty() && nums[dq.getLast()] < nums[right]) {
                dq.removeLast(); // remove smaller elements automatically
            }
            dq.addLast(right);

            if (right - left + 1 == k) {
                list.add(nums[dq.getFirst()]);
                if (dq.getFirst() == left) {
                    dq.removeFirst();
                }
                left++;
            }

        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
