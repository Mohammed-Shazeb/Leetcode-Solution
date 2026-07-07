class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> sForOperators = new Stack<>();
        Stack<Character> sForOperands = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (ch == '|' || ch == '&' || ch == '!') {
                sForOperators.push(ch);
            }

            else if (ch == ')') {
                boolean ans;

                char currOperator = sForOperators.pop();

                if (currOperator == '&')
                    ans = true;
                else
                    ans = false;

                while (sForOperands.peek() != '(') {
                    char currOperand = sForOperands.pop();

                    if (currOperator == '&')
                        ans &= (currOperand == 't');

                    if (currOperator == '|')
                        ans |= (currOperand == 't');

                    if (currOperator == '!')
                        ans = !(currOperand == 't');
                }

                sForOperands.pop(); // <-- remove '('
                sForOperands.push(ans ? 't' : 'f');
            }

            else if (ch == 't' || ch == 'f') {
                // If the character is an operand ('t' or 'f'), push it onto the opr stack
                sForOperands.push(ch);
            } else if (ch == ',')
                continue;
            else if (ch == '(') {
                // If the character is an opening parenthesis, push it onto the opr stack
                sForOperands.push(ch);
            }
        }
        if (sForOperands.pop() == 't')
            return true;
        return false;
    }
}
