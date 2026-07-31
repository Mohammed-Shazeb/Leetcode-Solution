class Solution {
    public int minimumPushes(String word) {
        // HashSet<Integer> set = new HashSet<>();

        HashMap<Character, Integer> map = new HashMap<>();  //char, freq
        for(char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        // int n  = word.length();
        int res=0;
        int value = 1;

        List<Integer> freq = new ArrayList<>();

        for (int count : map.values()) {
            freq.add(count);
        }
        Collections.sort(freq, Collections.reverseOrder());
        int n = freq.size();

        for(int i=0;i<n;i+=8) {
            for(int j=i; j<Math.min(i + 8, n);j++) { 
                res += freq.get(j)*value;
            }
            value++;
        }
        return res;



        // HashMap<Character, Integer> map = new HashMap<>();  //char, freq
        // char[] chars = word.toCharArray();
        // Arrays.sort(chars);
        // word = new String(chars);

        // for(char c : word.toCharArray()) {
        //     map.add(c, map.getOrDefault(c, 0)+1);
        // }


        // for(int i=0;i<n;i+=8) {
        //     for(int j=i; j<Math.min(i + 8, n);j++) { 
        //         char curr = word.charAt(j);
        //         if (!map.containsKey(curr)) {
        //             map.put(curr, new int[]{1, 1});
        //         } else {
        //             map.get(curr)[0]++;   // Increment frequency only
        //             map.get(curr)[1] = value;
        //         }
        //     }
        //     value++;
        // }

        // for(int arr[] : map.values()) {
        //     res += (arr[0]*arr[1]);
        // }
        // return res;       
    }
}
