import java.util.*;

class Solution {
    public static String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String curr = str[i];
            if (curr.equals(".") || curr.equals("")) {
                continue;
            } else if (curr.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(curr);
            }
        }
        String result = "";
        while (!s.isEmpty()) {
            result = "/" + s.pop() + result;
        }
        if (result.equals("")) {
            return "/";
        }

        return result;
    }

}
