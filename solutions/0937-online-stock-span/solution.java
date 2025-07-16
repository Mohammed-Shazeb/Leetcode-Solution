import java.util.Stack;
class StockSpanner {
    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
        // stack = new Stack<>();
    }
    
    
    public int next(int price) {
       int span = 1;
       while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        for (int p : prices) {
            System.out.println(spanner.next(p));
        }
    }
   
}



/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
