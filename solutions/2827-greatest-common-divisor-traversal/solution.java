class Solution {
    int[] parent;
    int[] rank;

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) {
            parent[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        } else {
            parent[parA] = parB;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return true;
        }

        for (int num : nums) {
            if (num == 1) {
                return false;
            }
        }

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        //find prime factor
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int div = 2; div * div <= num; div++) {

                if (num % div == 0) {
                    map.putIfAbsent(div, new ArrayList<>());
                    map.get(div).add(i);

                    while (num % div == 0) {
                        num /= div;
                    }
                }
            }
            if (num > 1) {
                map.putIfAbsent(num, new ArrayList<>());
                map.get(num).add(i);
            }

        }

        // 2 -> [2,6]
        // 3 -> [3,6]

        // do the union 
        for (List<Integer> values : map.values()) {
            for (int i = 1; i < values.size(); i++) {
                union(values.get(0), values.get(i));
            }
        }
        int root = find(0);

        for (int i = 1; i < n; i++) {
            if (find(i) != root) {
                return false;
            }
        }

        return true;

    }
}
