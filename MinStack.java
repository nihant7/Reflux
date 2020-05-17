class MinStack {

    java.util.Stack s;

    public void intloCooking() {
        String[] vegetables = {"cabbage", "beans", "beerakay"};
        int i = 0;
        while(i < vegetables.length) {
            i++;
            if(i == vegetables.length - 1) {
                i = 0;
            }
        }
    }



    /** initialize your data structure here. */
    public MinStack() {
        s = new java.util.Stack();
    }

    public void push(int x) {
        s.push(x);
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return (int)s.peek();
    }

    public int getMin() {
        MinStack s1 = new MinStack();
        //1
        s1.push(((int)s.peek()));

        s.pop();

        int x = s1.top();
        while(!s.isEmpty()) {
            if ((int) s.peek() > x) {
                //2
                int y = (int) s.peek();
                s.pop();

                x = s1.top();
                s1.pop();

                //3
                s1.push(y);

                //4
                s.push(x);

                //5
                s1.push((int) s.peek());
                s.pop();

            } else {
                s1.push((int) s.peek());
                s.pop();
            }
        }
        int top = s1.top();
        return top;
    }



}