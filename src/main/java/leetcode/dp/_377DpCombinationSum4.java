package leetcode.dp;

import java.util.Arrays;

/**
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 *
 * 题目数据保证答案符合 32 位整数范围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/19
 */
public class _377DpCombinationSum4 {

    public static void main(String[] args) {

        int res = combinationSum4(new int[]{1, 2, 3}, 4);
        System.out.println(res);
    }

    public static int combinationSum4(int[] nums, int target) {
        /**
         * 当 1≤i≤target 时，如果存在一种排列，其中的元素之和等于 i，则该排列的最后一个元素一定是数组 nums 中的一个元素。
         * 假设该排列的最后一个元素是 num，则一定有 num≤i，对于元素之和等于 i?num 的每一种排列，
         * 在最后添加 num 之后即可得到一个元素之和等于 i 的排列，因此在计算 dp[i] 时，应该计算所有的 dp[i?num] 之和。
         *
         */
        // dp[i] 表示总和为 i 的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
