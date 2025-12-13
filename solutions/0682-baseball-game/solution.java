class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(String g:operations){
            if(g.charAt(0)=='C'){
                st.pop();
            }else if(g.charAt(0)=='D'){
                int a=st.peek();
                st.push(a*2);
            }else if(g.charAt(0)=='+'){
                int a=st.pop();
                int b=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }else{
                int a=Integer.parseInt(g);
                st.push(a);
            }
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}
