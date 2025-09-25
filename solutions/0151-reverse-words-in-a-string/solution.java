class Solution {
    public String reverseWords(String s) {
        // Split by spaces (each word will be an element in the array)
        // String[] words = s.trim().split("\\s+");    
        // // this above will convert this "the sky is blue" ==> [the, sky, is, blue];
        // s = "";
        // int n = words.length;
        // int j = n-1;
        // while(j>=0){
        //     s += words[j--];
        //     if(j >= 0)s += " ";
        // }
        // return s;


        s = s.trim();
        String[] word = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i=word.length-1; i>=0; i--){
            sb.append(word[i]);
            if(i > 0){
                sb.append(" ");
            }
            
        }
        return sb.toString();
    }
}
