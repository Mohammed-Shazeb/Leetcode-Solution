class Solution {
    public double dfs(String src, String dest, Set<String> visited,  Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(src)) return -1;

        if(graph.get(src).containsKey(dest)) {
            return graph.get(src).get(dest);
        }

        visited.add(src);

        for (String neighbor : graph.get(src).keySet()) {
            if(!visited.contains(neighbor)) {
                double product = dfs(neighbor, dest, visited, graph);

                if(product != -1.0) {
                    return graph.get(src).get(neighbor) * product;
                }
            }
        }
        return -1;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        // a -> (b, 2.0)

        for(int i=0; i<equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);

            double val = values[i];

            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());

            graph.get(A).put(B, val);
            graph.get(B).put(A, 1.0/val);
        }

        double res[] = new double[queries.size()];
        int idx = 0;

        for(List<String> query: queries) {
            String src = query.get(0);
            String dest = query.get(1);

            Set<String> visited = new HashSet<>(); 
            res[idx++] = dfs(src, dest, visited, graph);
        }
        return res;
    }
}
