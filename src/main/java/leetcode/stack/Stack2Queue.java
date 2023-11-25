package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/7/11
 * @description:
 */
public class Stack2Queue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.peek());
        while (!myQueue.empty()) {
            System.out.println("peek: "+myQueue.peek());
            System.out.println(myQueue.pop());
        }
    }
}

class MyQueue {

    private final Deque<Integer> in = new LinkedList<>();
    private final Deque<Integer> out = new LinkedList<>();

    public MyQueue() {

    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        Integer first = this.pop();
        out.push(first);
        return first;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
