class Solution {
    public int[] shuffle(int[] nums, int n) {
        int size = nums.length;
        int arr[] = new int[size];
        int i = 0;
        int j = n;
        int k = 0;
        while(i<n && j<size && k < size){
            arr[k++] = nums[i++];
            arr[k++] = nums[j++];
        }
        return arr;
        
    }
}
