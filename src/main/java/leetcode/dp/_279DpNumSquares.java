package leetcode.dp;

/**
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/20
 */
public class _279DpNumSquares {

    public static void main(String[] args) {

        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {

        // dp[i] 表示凑成总和为 i 的最少平方数的个数
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 当和为0时，组合的个数为0
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
