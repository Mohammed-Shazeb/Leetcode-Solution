// class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int i = floorIndex(arr, x); // now i is index
//         int j = i + 1;

//         List<Integer> ans = new ArrayList<>();

//         while (i >= 0 && j < arr.length && k > 0) {
//             if (Math.abs(x - arr[i]) <= Math.abs(x - arr[j])) {
//                 ans.add(arr[i--]);
//             } else {
//                 ans.add(arr[j++]);
//             }
//             k--;
//         }
//         while (i >= 0 && k > 0) {
//             ans.add(arr[i--]);
//             k--;
//         }
//         while (j < arr.length && k > 0) {
//             ans.add(arr[j++]);
//             k--;
//         }

//         Collections.sort(ans); // result must be sorted
//         return ans;
//     }

//     private int floorIndex(int[] arr, int target) {
//         int low = 0;
//         int high = arr.length - 1;
//         int ans = -1; // store the floor value index

//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (arr[mid] == target) {
//                 return mid; // exact match
//             } else if (arr[mid] < target) {
//                 ans = mid; // possible floor
//                 low = mid + 1; // search right for a closer floor
//             } else {
//                 high = mid - 1; // search left
//             }
//         }

//         return ans; // returns -1 if no floor exists
//     }
// }

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        List<Integer> result = new ArrayList<>();

        while (end - start >= k) {
            if (Math.abs(x - arr[start]) > Math.abs(x - arr[end])) {
                start++;
            } else {
                end--;
            }
        }
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
