package leetcode.dp;

import java.util.Arrays;

/**
 * ����һ���Ǹ��������� nums ��һ������ target ��
 *
 * �������е�ÿ������ǰ��� '+' �� '-' ��Ȼ�������������������Թ���һ�� ���ʽ ��
 *
 * ���磬nums = [2, 1] �������� 2 ֮ǰ��� '+' ���� 1 ֮ǰ��� '-' ��Ȼ���������õ����ʽ "+2-1" ��
 * ���ؿ���ͨ��������������ġ����������� target �Ĳ�ͬ ���ʽ ����Ŀ��
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,1,1,1,1], target = 3
 * �����5
 * ���ͣ�һ���� 5 �ַ���������Ŀ���Ϊ 3 ��
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

        // ����j������j����ô���ݻ��İ�����dp[j]�ַ���
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
