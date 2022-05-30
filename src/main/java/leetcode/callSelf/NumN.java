package leetcode.callSelf;

/**
 * 求x的n次方
 */
public class NumN {

    public static void main(String[] args) {
        int x = 5;
        int n = 3;
        int result = function1(x, n);
        int result2 = function2(x, n);
        int result3 = function3(x, n);
        int result4 = function4(x, n);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
    }

    /**
     * O(logn)
     * @param x
     * @param n
     * @return
     */
    private static int function4(int x, int n) {
        if (n == 0) {
            return 1;
        }
        // 重复利用之前计算过的数据
        int t = function4(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        } else {
            return t * t;
        }
    }

    /**
     * O(n)
     * @param x
     * @param n
     * @return
     */
    private static int function3(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 1) {
            return function3(x, n / 2) * function3(x, n / 2) * x;
        } else {
            return function3(x, n / 2) * function3(x, n / 2);
        }
    }

    /**
     * O(n)
     * @param x
     * @param n
     * @return
     */
    private static int function2(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return function2(x, n - 1) * x;
        }
    }

    /**
     * O(n)
     * @param x
     * @param n
     * @return
     */
    private static int function1(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }


}
