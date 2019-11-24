public class Stack {
    int items;
    int[] arr = new int[100];



    public void push(int data) {
        if(!isFull()) {
            arr[items++] = data;
        }
        else {
            return;
        }
    }

    private boolean isFull() {
        if(items >= 100) {
            return true;
        }
        return false;
    }

    public int pop() {
        if(!isEmpty()) {
            int temp = arr[--items];
            return temp;
        }
        else {
            return -1;
        }
    }

    private boolean isEmpty() {
        if(items < 0)
            return true;
        else return false;
    }

    public void display() {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != '\0')
            System.out.println(arr[i]);
        }
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

    }
}
