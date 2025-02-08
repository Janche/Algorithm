package leetcode.dp;

/**
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 *
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/18
 */
public class _474DpOneAndZero {

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 1, n = 1;
        int maxForm = findMaxForm(strs, m, n);
        String[] strs2 = {"10", "0", "1"};
        maxForm = findMaxForm2(strs2, m, n);
        System.out.println(maxForm);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示 i 个 0 和 j 个 1 的最大子集的长度
        int[][] dp = new int[m + 1][n + 1];
        // 字符串相当于是物品，0 的个数和 1 的个数相当于是 背包的容量 ，因此这是一个典型的01背包，先遍历物品，后遍历容量，容量倒序遍历
        for (String str: strs) {
            int[] nums = getNumsByStr(str);
            int zeros = nums[0], ones = nums[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] getNumsByStr(String str) {
        int[] nums = new int[2];
        for (char c: str.toCharArray()) {
            nums[c - '0']++;
        }
        return nums;
    }

    public static int findMaxForm2(String[] strs, int m, int n) {
        int len = strs.length;
        // dp[i][j][k] 表示 0~i 个 字符串 0 的个数为 j, 1 的个数为 k 的最大子集的长度
        int[][][] dp = new int[len][m + 1][n + 1];

        // 初始化：为了避免分类讨论，通常多设置一行。这里可以认为，第 0 个字符串是空串。第 0 行默认初始化为 0。
        // initialize the 1st plane of dp[i][j][k], i.e., dp[0][j][k]
        // if nums0[0] > m or nums0[1] > n, no need to further initialize dp[0][j][k],
        // because they have been intialized to 0 previously
        int[] nums0 = getNumsByStr(strs[0]);
        if(nums0[0] <= m && nums0[1] <= n){
            // for j < nums0[0] or k < nums0[1], dp[0][j][k] = 0
            for(int j = nums0[0]; j <= m; j++){
                for(int k = nums0[1]; k <= n; k++){
                    dp[0][j][k] = 1;
                }
            }
        }

        for (int i = 1; i < len; i++) {
            int[] nums = getNumsByStr(strs[i]);
            int zeros = nums[0], ones = nums[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }

        return dp[len - 1][m][n];
    }
}
