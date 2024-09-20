package leetcode.dp;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/20
 */
public class _322DpCashChange1 {
    public static void main(String[] args) {
        int res = coinChange(new int[]{2}, 3);
        System.out.println(res);
//        System.out.println(coinChange(new int[]{1}, 0));
    }

    public static int coinChange(int[] coins, int amount) {

        // dp[i] 表示凑成总金额为 i 的最少硬币个数
        int[] dp = new int[amount + 1];

        // 初始化
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE - 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
