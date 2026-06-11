class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    private void dfs(String airport) {
        PriorityQueue<String> neighbors = graph.get(airport);

        while(neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll());
        }
        itinerary.addFirst(airport);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            if (!graph.containsKey(from)) {
                graph.put(from, new PriorityQueue<>());
            }

            graph.get(from).add(to);
        }
    
        dfs("JFK");
        return itinerary;

    }
}
