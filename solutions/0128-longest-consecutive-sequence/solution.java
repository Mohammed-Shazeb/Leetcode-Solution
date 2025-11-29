class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);   // O(N)

        int longest = 0;

        for (int n : set) {              // O(N)
            if (!set.contains(n - 1)) {  // Only start from sequence beginning
                int length = 1;
                int curr = n;

                while (set.contains(curr + 1)) {  // Consecutive scan
                    curr++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

