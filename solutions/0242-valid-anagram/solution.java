class Solution {
    public boolean isAnagram(String s, String t) {
        char[] charArrayForS = s.toCharArray();
        char[] charArrayForT = t.toCharArray();
        Arrays.sort(charArrayForS);
        Arrays.sort(charArrayForT);
        if(charArrayForS.length != charArrayForT.length) return false;
        boolean result =  Arrays.equals(charArrayForS,charArrayForT);
        return result;
    }
}
