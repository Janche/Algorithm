package leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lirong
 * @date: 2023/7/12
 * @description:
 */
public class Queue2Stack {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
//        myStack.push(3);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
//        System.out.println(myStack.pop());
//        System.out.println(myStack.pop());
    }
}

class MyStack {
    private final Deque<Integer> que1 = new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        que1.add(x);
    }

    public int pop() {
        return que1.removeLast();
    }

    public int top() {
        return que1.getLast();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}

class Stack {

    private final Queue<Integer> que1 = new LinkedList<>();
//    private final Queue<Integer> que2 = new LinkedList<>();
    public Stack() {

    }

    public void push(int x) {
        que1.add(x);
        int size = que1.size();
        while (size-- > 1) {
            que1.add(que1.poll());
        }
    }

    public int pop() {
        return que1.poll();
    }

    public int top() {
        return que1.peek();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}