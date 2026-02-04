class TimeMap {

    private Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Node(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<Node> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            Node midNode = list.get(mid);

            if(midNode.time <= timestamp) {
                result = midNode.value;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return result;
    }
}

class Node {
    String value;
    int time;

    Node(String value, int time) {
        this.value = value;
        this.time = time;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
