class Solution {
    public int compress(char[] chars) {
        String str = "";
        int n = chars.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            chars[j++] = chars[i];
            if (count > 1) {
                // lets say count is 12 this will convert count to '12' 
                String countStr = Integer.toString(count);

                //'12' => [1,2]   
                for (char c : countStr.toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}
