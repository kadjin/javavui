public class Stack {
    private int[] stack; 
    private int top;     

    public Stack(int capacity) {
        stack = new int[capacity]; 
        top = -1;                   
    }

    public boolean isEmpty() {
        return top == -1;  
    }
    public boolean isFull() {
        return top == stack.length - 1; 
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full, cannot push " + value);  
            return;
        }
        stack[++top] = value; 
        System.out.println(value + " pushed to stack");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");  
            return -1;  
        }
        int poppedValue = stack[top--];  
        return poppedValue;
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");  
            return -1; 
        }
        return stack[top];  
    }
}
