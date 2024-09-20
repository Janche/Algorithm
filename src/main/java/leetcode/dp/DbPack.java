package leetcode.dp;

/**
 * 背包问题
 */
public class DbPack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] values = {15, 20, 30};
        int bag = 4;

        int res = dbPack(weight, values, bag);
        int res2 = dbPack2(weight, values, bag);

        System.out.println(res);
        System.out.println(res2);

    }

    public static int dbPack2(int[] weight, int[] values, int bag) {
        int len = weight.length;
        // dp[i] 表示背包容量为 i 的最大价值
        int[] dp = new int[bag + 1];

        for (int i = 0; i < len; i++) {
            for (int j = weight[i]; j <= bag; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
        }
        return dp[bag];
    }

    public static int dbPack(int[] weight, int[] values, int bag) {
        int len = weight.length;
        // dp[i][j] 表示前 i 个物品，背包容量为 j 的最大价值
        int[][] dp = new int[len + 1][bag + 1];

        // 初始化
        for(int j = weight[0]; j <= bag; j++){
            // 初始化第一行
            dp[0][j] += dp[0][j - weight[0]] + values[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= bag; j++) {
                if(j < weight[i]){
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j - weight[i]] + values[i]);
                }
            }
        }

        return dp[len-1][bag];
    }
}
