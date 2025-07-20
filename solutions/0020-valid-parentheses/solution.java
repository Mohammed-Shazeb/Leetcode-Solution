import java.util.*;

class Solution {
    public static boolean isValid(String s) {
        char ch;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
            if((ch == '(') || (ch == '{') || (ch == '[')){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                if((st.peek() == '(' && ch == ')') || (st.peek() == '{' && ch == '}')|| (st.peek() == '[' && ch == ']')){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
         if(st.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String []args){
        String s = "(){}[]";
        System.out.println(isValid(s)); 
    }
}
