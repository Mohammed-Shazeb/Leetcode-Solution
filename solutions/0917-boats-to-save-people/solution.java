// Pair the heaviest person with the lightest possible to save boats.
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int si = 0;                              // lightest person
        int ei = people.length - 1;              // heaviest person
        int boats = 0;

        while (si <= ei) {

            if (people[si] + people[ei] <= limit) {
                si = si + 1;                    // pair lightest with heaviest
                ei = ei - 1;
            } 
            else {
                ei = ei - 1;                   // heaviest goes alone
            }
            boats = boats + 1;                 // one boat used each iteration
        } 
        return boats;
    }
}
