import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://oj.leetcode.com/problems/min-stack/
 * Created by lgylym on 14-11-13.
 */
class MinStack {
    Deque<Integer> stack = new ArrayDeque<Integer>();
    Deque<Integer> minStack = new ArrayDeque<Integer>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        }else {
            int currentMin = minStack.peek();
            if(x <= currentMin) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int item = stack.poll();
        int cmin = minStack.peek();
        if(item == cmin){
            minStack.poll();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(1);
        ms.push(-2147483648);
        System.out.println(ms.top());
        System.out.println(ms.getMin());
    }
}