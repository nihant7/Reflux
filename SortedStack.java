import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedStack {
    int a = 0;



    public void sort(java.util.Stack<Integer> stack) {
        java.util.Stack<Integer> reverse = new java.util.Stack<Integer>();
        while(!stack.isEmpty()) {
            int popItem = stack.pop();
            while(!reverse.isEmpty() && reverse.peek() > popItem) {
                reverse.push(stack.pop());
            }
            reverse.push(popItem);
        }
    }


    public void reverse(java.util.Stack<Integer> stack) {

            if(stack.size() > 0) {
                int a = stack.peek();
                stack.pop();
                reverse(stack);
                stack.push(a);
            }

            else return;






    }



    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        SortedStack s = new SortedStack();
        s.reverse(stack);
        System.out.println(stack);
    }
}
