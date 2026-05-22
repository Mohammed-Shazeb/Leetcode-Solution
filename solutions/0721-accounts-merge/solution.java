class Solution {

    int parent[] = new int[1001];
    int rank[] = new int[1001];

    public void initialize(int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA == parB) return;

        if (rank[parA] == rank[parB]) {
            parent[parB] = parA;
            rank[parA]++;
        }
        else if (rank[parA] > rank[parB]) {
            parent[parB] = parA;
        }
        else {
            parent[parA] = parB;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();

        initialize(n);

        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Union accounts having same email
        for (int i = 0; i < n; i++) {

            for (int j = 1; j < accounts.get(i).size(); j++) {

                String mail = accounts.get(i).get(j);

                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                }
                else {
                    union(i, map.get(mail));
                }
            }
        }

        // Step 2: Group mails by parent
        ArrayList<String>[] mergedMail = new ArrayList[n];

        for(int i=0; i<n; i++) {
            mergedMail[i] = new ArrayList<>();
        }

        for(Map.Entry<String, Integer> val : map.entrySet()) {
            String mail = val.getKey();
            int node = find(val.getValue());  // if the value have a parent find its parent
            mergedMail[node].add(mail);
        }
        

        // Step 3: Build answer
        List<List<String>> ans = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(mergedMail[i].size() == 0) continue;

            Collections.sort(mergedMail[i]);

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));

            for(String str: mergedMail[i]) {
                temp.add(str);
            }
            
            
            ans.add(temp);
            
        }

        return ans;
    }
}
