class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();

        int si = 0;
        int ei = str.length()-1;

        while(si<ei){
            while(si<ei && !Character.isLetterOrDigit(str.charAt(si))) {
                si++;
            }
            while(si<ei && !Character.isLetterOrDigit(str.charAt(ei))) {
                ei--;
            }
            if(str.charAt(si) != str.charAt(ei)){
                return false;   
            }
            si++;
            ei--;
        }
        return true;
    }
}
