class Solution {
    public String minWindow(String s, String t) {
        // Handle empty strings
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // Frequency map for characters in t
        int[] charCounts = new int[256]; // Using an array for ASCII characters

        // Populate charCounts with frequencies of characters in t
        for (char c : t.toCharArray()) {
            charCounts[c]++;
        }

        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0; // To track how many characters from t are currently in the window

        // N and M sizes
        int n = s.length();
        int m = t.length();

        // Sliding window loop (expand with right pointer)
        while (right < n) {
            char rChar = s.charAt(right);

            // If the character is needed from t, decrement its count in map and increment 'count'
            // A character is "needed" if its count in charCounts is still positive (meaning we still need to find it)
            if (charCounts[rChar] > 0) {
                count++;
            }
            charCounts[rChar]--; // Decrement the count for the character at right pointer
 
            // When all characters from t are found in the current window
            while (count == m) {
                // Update minimum length and starting index
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                // Try to shrink the window from the left
                char lChar = s.charAt(left);
                charCounts[lChar]++; // Increment the count as we remove it from the window

                // If removing this character means we now need it again for t,
                // decrement 'count' because the window is no longer "valid" for t
                if (charCounts[lChar] > 0) {
                    count--;
                }
                left++; // Move left pointer to shrink the window
            }
            right++; // Move right pointer to expand the window
        }

        // If no valid window was found
        if (startIndex == -1) {
            return "";
        }

        // Return the minimum window substring
        return s.substring(startIndex, startIndex + minLength);

    }
}
