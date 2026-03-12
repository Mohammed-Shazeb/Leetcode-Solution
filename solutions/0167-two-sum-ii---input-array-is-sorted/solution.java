class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int arr[] = new int[2];

        int si = 0;
        int ei = numbers.length-1;

        while(si<=ei) {
            if(numbers[si] + numbers[ei] == target) {
                arr[0] = si+1;
                arr[1] = ei+1;
                break;
            } 
            else if(numbers[si] + numbers[ei] <= target) si++;
            else ei--;
        }
        return arr;
    }
}
