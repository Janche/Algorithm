package leetcode.dp;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: lirong
 * @Date: 2025/02/06
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 */
public class _416DpSplitSubList {

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5, 2};
        boolean res = canPartition(arr);
        System.out.println(res);

        System.out.println(canPartition1(arr));
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        // dp[i][j] 表示前 i 个数中能否找到和为 j 的子集
        boolean[][] dp = new boolean[len + 1][target + 1];
        // 初始化
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选或者不选
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return true;
    }

    public static boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;

        // dp[i] 表示和为 i 的子集是否存在
        int[] dp = new int[target + 1];

        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 如果 dp[target] == target，说明找到了和为 target 的子集
            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }
}
