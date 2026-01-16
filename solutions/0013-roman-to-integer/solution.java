class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanletters = {"M", "CM", "D", "CD", "C", "XC","L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < romanletters.length; i++) {
            while (s.startsWith(romanletters[i])) {
                result += values[i];
                s = s.substring(romanletters[i].length());
            }
        }
        return result;  
    }
}
