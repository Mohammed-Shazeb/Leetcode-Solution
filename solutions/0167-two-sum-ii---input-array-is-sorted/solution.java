class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int si = 0;
        int ei = numbers.length-1;

        while (si <= ei) {
            if (numbers[si] + numbers[ei] == target) {
                res[0] = si+1;
                res[1] = ei+1;
                break;
            } 
            else if (numbers[si] + numbers[ei] < target) {
                si++;
            } 
            else if (numbers[si] + numbers[ei] > target){
                ei--;
            }
            else{
                break;
            }
            
        }
        return res;
    }
}
