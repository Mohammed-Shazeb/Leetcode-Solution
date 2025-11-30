class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0) {
            sum = carry;
            if (i >= 0) {
                sum += num[i--];
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            list.add(sum % 10);
            carry = sum / 10;

        }
        if (carry > 0) {
            list.add(carry);
        }
        Collections.reverse(list);
        return list;
    }
}
