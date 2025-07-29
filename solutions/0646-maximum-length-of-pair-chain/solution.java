import java.util.*;
class Solution {
    public static int findLongestChain(int[][] pairs) {
        // ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[1],b[1]));
        int counter = 1;
        // list.add(pairs[0][0]);
        int lastEnd = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0] > lastEnd){
                // list.add(pairs[i][0]);
                lastEnd = pairs[i][1];
                counter++;
            }
        }
        // System.out.println("Maximum activities are "+counter);
        return counter;
    }
    public static void main(String args[]){
        int pairs[][] = {{5,25},{39,60},{27,40},{50,90}};
        System.out.println(findLongestChain(pairs));
    }
}
