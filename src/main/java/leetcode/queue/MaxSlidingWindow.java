package leetcode.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/7/9
 * @description:
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};

        int[] res = maxSlidingWindow(arr, 3);
        Arrays.stream(res).forEach(System.out::println);
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int[] res = new int[nums.length - k + 1];
//        Queue myQueue = new Queue();
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!que.isEmpty() && que.getLast() < nums[i]) {
                que.removeLast();
            }
            que.add(nums[i]);
        }
        res[0] = que.peek();
        for (int i = k; i < nums.length; i++) {
            if (!que.isEmpty() && que.peek() == nums[i - k]) {
                que.poll();
            }
            while (!que.isEmpty() && que.getLast() < nums[i]) {
                que.removeLast();
            }
            que.add(nums[i]);
            res[i - k + 1] = que.peek();
        }
        return res;
    }
}

class Queue {
   final Deque<Integer> que =  new LinkedList<>();

   void pop(int val) {
       if (!que.isEmpty() && que.peek() == val) {
            que.pop();
       }
   }

   void push(int val) {
       while (!que.isEmpty() && que.getLast() < val) {
           que.removeLast();
       }
       que.add(val);
   }



   int peek() {
       return que.peek();
   }
}
