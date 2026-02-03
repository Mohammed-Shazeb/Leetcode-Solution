class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;
        int sum = 0;

        while(i>=0 || j>=0 || carry !=0) {
            sum = 0 + carry;
            if(i>=0) {
                char currA = a.charAt(i);
                sum += currA - '0';
            }
            i--;
            if(j>=0) {
                char currB = b.charAt(j);
                sum += currB - '0';
            }
            j--;

            carry = sum / 2;
            sum = sum % 2;
            sb.append(sum);
        }
        return sb.reverse().toString();
    }
}
