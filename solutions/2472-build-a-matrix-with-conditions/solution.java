class Solution {
    public List<Integer> topSort(int k, int[][] conditions) {
        ArrayList<Integer> graph[] = new ArrayList[k + 1];

        for (int i = 0; i <= k; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indeg = new int[k + 1];
        for (int condition[] : conditions) {
            int u = condition[0];
            int v = condition[1];

            graph[u].add(v);
            indeg[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // i should not start from 0 cause no's are from 1tok
        // we were adding 0 which will return empty list 
        for (int i = 1; i <= k; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int curr = q.remove();
            topo.add(curr);

            for (int nei : graph[curr]) {
                indeg[nei]--;

                if (indeg[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        return topo.size() == k ? topo : new ArrayList<>();
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowTopo = topSort(k, rowConditions);
        List<Integer> colTopo = topSort(k, colConditions);

        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];

        if(rowTopo.size() != k || colTopo.size() != k) {
            return new int[0][0];
        }

        for (int i = 0; i < rowTopo.size(); i++) {
            rowPos[rowTopo.get(i)] = i;
        }

        for (int i = 0; i < colTopo.size(); i++) {
            colPos[colTopo.get(i)] = i;
        }

        int matrix[][] = new int[k][k];

        // for (int row[] : matrix) {
        //     Arrays.fill(row, -1);
        // }
        for (int num = 1; num <= k; num++) {
            matrix[rowPos[num]][colPos[num]] = num;
        }
        // for (int i = 0; i < k; i++) {
        //     for (int j = 0; j < k; j++) {
        //         if (matrix[i][j] == -1)
        //             matrix[i][j] = 0;
        //     }
        // }
        return matrix;
    }
}
