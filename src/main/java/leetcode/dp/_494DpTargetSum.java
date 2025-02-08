package leetcode.dp;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * @Auther: lirong
 * @Date: 2024/06/03
 */
public class _494DpTargetSum {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        int ways = findTargetSumWays(nums, target);
        System.out.println(ways);
    }

    public static int findTargetSumWays(int[] nums, int target) {

        // left + right = sum
        // left - right = target
        // left = (sum + target) / 2
        int sum = Arrays.stream(nums).sum();
        int left = (sum + target) / 2;

        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        // 填满j（包括j）这么大容积的包，有dp[j]种方法
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
                System.out.println("i:" + i + " + j:" + j + " = " + dp[j]);
            }
            System.out.println("=========");
        }
        return dp[left];
    }
}
