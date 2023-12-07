// Link : https://www.codingninjas.com/studio/problems/two-stacks_983634
// Solution : https://www.youtube.com/watch?v=_6COl6V6mng&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=59&t=1890s

package Stacks;

// Logic : Push elements in stack1 from left to right and push elements in stack2 from right to left.

class TwoStack {

    // Initialize TwoStack.
    int[] arr;
    int top1;
    int top2;
    int size;

    public TwoStack(int s) {
        // Write your code here
        this.size = s;
        arr = new int[s];
        top1 = -1;
        top2 = size;
        for (int i = 0; i < s; i++) {
            arr[i] = -1;
        }
    }

    // Push in stack 1.
    public void push1(int num) {
        // Write your code here

        if ((top1 + 1) < size && arr[top1 + 1] == -1) {
            top1++;
            arr[top1] = num;
        }

    }

    // Push in stack 2.
    public void push2(int num) {
        // Write your code here
        if ((top2 - 1) >= 0 && arr[top2 - 1] == -1) {
            top2--;
            arr[top2] = num;
        }
    }

    // Pop from stack 1 and return popped element.
    public int pop1() {
        // Write your code here
        if (top1 == -1) {
            return -1;
        }
        int poppedElement = arr[top1];
        arr[top1] = -1;
        top1--;

        return poppedElement;
    }

    // Pop from stack 2 and return popped element.
    public int pop2() {
        // Write your code here
        if (top2 == size) {
            return -1;
        }
        int poppedElement = arr[top2];
        arr[top2] = -1;
        top2++;

        return poppedElement;
    }

}