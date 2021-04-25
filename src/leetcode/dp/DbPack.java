package leetcode.dp;

/**
 * 背包问题
 */
public class DbPack {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] values = {15, 20, 30};

        int bag = 4;
        int len = weight.length;
        int[][] dp = new int[len + 1][bag + 1];

        // 初始化
        for (int j=bag; j>=weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + values[0];
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

        System.out.println(dp[len-1][bag]);

    }
}
