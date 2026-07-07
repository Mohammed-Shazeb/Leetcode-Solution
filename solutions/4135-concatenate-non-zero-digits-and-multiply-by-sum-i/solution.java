class Solution {
    public long sumAndMultiply(int n) {
        if(n == 0) return 0;
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        
        int sum = 0;
        
        while(n>0) {
            int lastDigit = n%10;
            if(lastDigit != 0) {
                list.addFirst(lastDigit);
                sum += lastDigit;
            } 
            n/=10;
        }
        for (int digit : list) {
            sb.append(digit);
        }
        
        return (long)sum * Long.parseLong(sb.toString());
    }
}
