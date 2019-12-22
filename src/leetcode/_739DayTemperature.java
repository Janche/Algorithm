package leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author lirong
 * @desc
 * @date 2019/12/17 22:14
 */
public class _739DayTemperature {

    public static void main(String[] args) {

        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] b = {89,62,70,58,47,47,46,76,100,70};

        test01(b);
        System.out.println();
        test02(b);
        System.out.println();
        test03(b);
        System.out.println();
        test04(b);

    }

    private static void test04(int[] a) {
        int length = a.length;
        int[] b = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0 ; i--) {
            while (!stack.isEmpty() && a[i] >= a[stack.peek()]){
                stack.pop();
            }
            b[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        Arrays.stream(b).forEach(e -> System.out.print(e + ","));
    }

    private static void test03(int[] a) {

        long startTime = System.currentTimeMillis();
        int length = a.length;
        int[] b = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += b[j]) {
                if (a[i] < a[j]){
                    b[i] = j - i;
                    break;
                }else if(b[j] == 0){
                    b[i] = 0;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        Arrays.stream(b).forEach(e -> System.out.print(e + ","));
    }

    private static void test02(int[] a) {
        long startTime = System.currentTimeMillis();
        int length = a.length;
        int[] b = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                if (a[i] < a[j]){
                    b[i] = j - i;
                    break;
                }
                if (a[i] == a[j]){
                    b[i] = b[j] == 0 ? 0 : b[j] + j - i;
                    break;
                }
                if (a[i] > a[j]){
                    j = b[j] == 0 ? j : j + b[j] - 1;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        Arrays.stream(b).forEach(e -> System.out.print(e + ","));
    }

    /**
     * ±©Á¦ÆÆ½â
     * @param a
     */
    private static void test01(int[] a) {
        long startTime = System.currentTimeMillis();
        int[] b = new int[a.length];
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] - a[i] > 0) {
                    b[i] = j - i;
                    break;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        Arrays.stream(b).forEach(e -> System.out.print(e + ","));
    }

}
