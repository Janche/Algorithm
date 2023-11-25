package leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: lirong
 * @date: 2023/7/16
 * @description:
 */
public class Äæ²¨À¼±í´ïÊ½ {
    public static void main(String[] args) {
        String[] tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
        System.out.println(evalRPN2(tokens));
    }

    public static int evalRPN(String[] tokens) {
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+")) {
                int last = stack.pop();
                stack.push(stack.pop() + last);
            } else if (token.equals("-")) {
                int last = stack.pop();
                stack.push(stack.pop() - last);
            } else if (token.equals("*")) {
                int last = stack.pop();
                stack.push(stack.pop() * last);
            } else if (token.equals("/")) {
                int last = stack.pop();
                stack.push(stack.pop() / last);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static int evalRPN2(String[] tokens) {
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.valueOf(token));
            } else {
                switch (token) {
                    case "+":
                        stack.push(stack.pop() + stack.pop());
                        break;
                    case "-":
                        stack.push(-stack.pop() + stack.pop());
                        break;
                    case "*":
                        stack.push(stack.pop() * stack.pop());
                        break;
                    case "/":
                        int last = stack.pop();
                        stack.push(stack.pop() / last);
                        break;
                    default:
                }
            }
        }
        return stack.pop();
    }

    public static boolean isNumber(String token) {
        return !("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token));
    }
}
