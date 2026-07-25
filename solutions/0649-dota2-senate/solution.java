class Solution {
    public void removeSenator(StringBuilder senate, boolean isDel[],char ch, int idx) {
            
        while(true) {
            if(senate.charAt(idx) == ch && isDel[idx] == false) {
                isDel[idx] = true;
                break;
            }
            idx = (idx + 1) % senate.length();
        }
        // return loopAround;
    }

    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);

        int rCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == 'R') {
                rCount++;
            }
        }

        int dCount = sb.length() - rCount;
        int idx = 0;

        boolean isDel[] = new boolean[senate.length()];

        while (rCount > 0 && dCount > 0) {

            if(!isDel[idx]) {
                if (sb.charAt(idx) == 'R') {
                    removeSenator(sb, isDel, 'D', (idx + 1) % sb.length());
                    dCount--;                    
                } else {
                    removeSenator(sb, isDel, 'R',(idx + 1) % sb.length());
                    rCount--;
                }
            }
            idx = (idx + 1) % sb.length();
        }
        return rCount == 0 ? "Dire" : "Radiant";
    }
}
