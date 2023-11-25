package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/7/13
 * @description:
 */
public class ¿®∫≈∆•≈‰ {
    public static void main(String[] args) {

        System.out.println(isValid("{}()((({{}})))"));
        System.out.println(isValid("{}()((({{}}))))"));

        System.out.println(removeDuplicates("asdbsdfddddfffdfdbc"));

        System.out.println(removeDuplicates("wrrrrdffdqqdwt"));
    }

    public static boolean isValid(String s) {
        final Deque<Character> stack = new LinkedList<>();
        char[] brackets = s.toCharArray();
        for (int i = 0; i < brackets.length; i++) {
            char bracket = brackets[i];
            if (bracket == '(') {
                stack.push(')');
            } else if(bracket == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.peek() != bracket) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static String removeDuplicates(String s) {
        final Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char a = chars[i];
            if (stack.isEmpty() || stack.peek() != a) {
                stack.push(a);
            } else {
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

}
