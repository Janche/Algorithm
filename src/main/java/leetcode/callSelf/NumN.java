package leetcode.callSelf;

import java.util.HashMap;

/**
 * 求x的n次方
 */
public class NumN {

    public static void main(String[] args) {
//        int x = 5;
//        int n = 3;
//        int result = function1(x, n);
//        int result2 = function2(x, n);
//        int result3 = function3(x, n);
//        int result4 = function4(x, n);
//        System.out.println(result);
//        System.out.println(result2);
//        System.out.println(result3);
//        System.out.println(result4);

//        double v = myPow(2.00000, -2147483648);
//        System.out.println(v);
//        int[] nums = {1,1,2};
//        int i = removeElement(nums);
//        System.out.println(i);
        int[] arr = {0,1,2,2};
        int i = totalFruit(arr);
        System.out.println(i);
    }

    public static int totalFruit(int[] fruits) {
        int in = 0; int out = 0; int ans = 0;
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(out = 0; out < fruits.length; out++) {
            int count = map.get(fruits[out]) == null ? 0: map.get(fruits[out]);
            map.put(fruits[out], count + 1);
            len = out - in + 1;
            while (map.size() > 2 && in <= out) {
                int key = fruits[in];
                int keyCount = map.get(fruits[in]);
                map.put(key, --keyCount);
                if (keyCount == 0){
                    map.remove(fruits[in]);
                }
                in++;
                len--;
            }
            ans = Math.max(ans, len);
        }
        return ans;
    }

    public static String checkStr(String str) {
        if (str == null || str.equals("") || str.equals("#")) return "";
        char[] arr = str.toCharArray();
        int left = 1; int right = 1;
        while(right < arr.length) {
            if (arr[right] == '#') {
                arr[left++] = arr[right+1];
            }
            right++;
        }
        for (int i = 0; i < left; i++) {

        }
        return String.valueOf(arr);
    }


    public static int removeElement(int[] nums) {
        int left = 0; int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                nums[++left] = nums[right++];
            } else {
                right++;
            }
        }
        return left + 1;
    }

    public static double myPow(double x, int n) {
        if (n < 0) {
            long k = n;
            return 1.0 / fun2(x, -k);
        }
        return fun2(x, n);
    }

    public static double fun2(double x, long n){
        if (n == 0) {
            return 1;
        }
        double t = fun2(x, n / 2);
        if (n % 2 == 1) {
            return t * t * x;
        }
        return t * t;
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
