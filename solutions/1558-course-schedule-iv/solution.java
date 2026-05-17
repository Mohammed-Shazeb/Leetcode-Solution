class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<Integer> graph[] = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        int indeg[] = new int[numCourses];

        for (int[] p : prerequisites) {
            int src = p[0];
            int dest = p[1];
            graph[src].add(dest);
            indeg[dest]++;
        }

        HashSet<Integer>[] prereq = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            prereq[i] = new HashSet<>();
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int nei : graph[curr]) {

                prereq[nei].add(curr);

                prereq[nei].addAll(prereq[curr]);

                indeg[nei]--;

                if (indeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];

            ans.add(prereq[b].contains(a));
        }

        return ans;
    }
}
