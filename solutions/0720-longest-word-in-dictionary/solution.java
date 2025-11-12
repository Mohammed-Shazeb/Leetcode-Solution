class Solution {
    class Node {
        Node Children[] = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                Children[i] = null;
            }
        }
    }

    public Node root = new Node();

    public void insert(String word) {
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                curr.Children[idx] = new Node();
            }
            curr = curr.Children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String key) {
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.Children[idx] == null) {
                return false;
            }
            curr = curr.Children[idx];
        }
        return curr.eow == true;
    }

    public String ans = "";

    public void longestWord(Node root, StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0; i<26; i++){
            if(root.Children[i] != null && root.Children[i].eow == true){
                char ch = (char) (i + 'a');
                temp.append(ch);
                
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.Children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }

    }

    public String longestWord(String[] words) {
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        return ans;
        
    }
}
