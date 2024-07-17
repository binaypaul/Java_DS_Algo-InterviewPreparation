package DataStructure.Neetcode.C_Stack;
//all operations should be in O(1) time
class b_MinStack {
    public b_MinStack() {

    }

    public void push(int val) {

    }

    public void pop() {

    }

    public int top() {

        return 0;
    }

    public int getMin() {

        return 0;
    }

    public static void main(String[] args) {
        b_MinStack minStack = new b_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */