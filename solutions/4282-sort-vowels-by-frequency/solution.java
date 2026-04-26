class Solution {
    public String sortVowels(String s) {

        int[] freq = new int[5];
        int[] first = new int[5];
        Arrays.fill(first, -1);

        char[] vowels = {'a','e','i','o','u'};

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            int idx = -1;
            if(c=='a') idx = 0;
            else if(c=='e') idx = 1;
            else if(c=='i') idx = 2;
            else if(c=='o') idx = 3;
            else if(c=='u') idx = 4;

            if(idx!=-1){
                freq[idx]++;
                if(first[idx]==-1) first[idx] = i;
            }
        }

        Integer[] order = {0,1,2,3,4};

        Arrays.sort(order,(a,b)->{
            if(freq[a]!=freq[b]) return freq[b]-freq[a];
            return first[a]-first[b];
        });

        char[] arr = s.toCharArray();
        int k = 0;

        for(int i=0; i<arr.length; i++) {
            if("aeiou".indexOf(arr[i]) != -1) {
                while(freq[order[k]] == 0) k++;
                arr[i] = vowels[order[k]];
                freq[order[k]]--;
            }
        }
        return new String(arr);
        
    }
}
