import java.util.HashMap;
import java.util.Stack;

/**
 * well explained in
 * http://stackoverflow.com/questions/9493853/given-an-array-find-out-the-next-minimum-element-for-each-element/9495815#9495815
 * Created by lgylym on 2014/11/19.
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] A) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < A.length; i++) {
            if(stack.isEmpty()) {
                stack.push(A[i]);
            }else {
                while(!stack.isEmpty()) {
                    int temp = stack.peek();
                    if (temp < A[i]) {
                        result.put(temp, A[i]);
                        stack.pop();
                    } else {
                        break;
                    }
                    stack.push(A[i]);
                }
            }
        }

        int[] r = new int[A.length];
        for(int i = 0; i < r.length; i++) {
            if(result.containsKey(A[i])) {
                r[i] = result.get(A[i]);
            }else {
                r[i] = -1;
            }
        }

        return r;
    }

}
