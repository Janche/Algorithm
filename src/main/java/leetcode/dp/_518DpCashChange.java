package leetcode.dp;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 *
 * 题目数据保证结果符合 32 位带符号整数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 *
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/19
 */
public class _518DpCashChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int res = change(amount, coins);
        res = change2(amount, coins);
        System.out.println(res);
    }

    public static int change(int amount, int[] coins) {
        // dp[i] 表示凑成总金额为 i 的硬币组合数
        int[] dp = new int[amount + 1];

        // 只有当不选取任何硬币时，金额之和才为 0，因此只有 1 种硬币组合
        dp[0] = 1;
        // 必须先遍历 coins，再遍历 amount，否则算出来的是 排列数，不是组合数
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // dp[i] 表示凑成总金额为 i 的硬币组合数
                // dp[i] = dp[i] + dp[i - coin]
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int change2(int amount, int[] coins) {
        // dp[i][j] 表示前 i 种硬币凑成金额 j 的组合数
        int[][] dp = new int[coins.length][amount+1];

        // 初始化边界值
        for(int i = 0; i < coins.length; i++){
            // 第一列的初始值为1
            dp[i][0] = 1;
        }
        for(int j = coins[0]; j <= amount; j++){
            // 初始化第一行
            dp[0][j] += dp[0][j-coins[0]];
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
            }
        }

        return dp[coins.length-1][amount];
    }
}
