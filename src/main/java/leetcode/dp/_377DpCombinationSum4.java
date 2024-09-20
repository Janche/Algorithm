package leetcode.dp;

import java.util.Arrays;

/**
 * ����һ���� ��ͬ ������ɵ����� nums ����һ��Ŀ������ target ������� nums ���ҳ��������ܺ�Ϊ target ��Ԫ����ϵĸ�����
 *
 * ��Ŀ���ݱ�֤�𰸷��� 32 λ������Χ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,2,3], target = 4
 * �����7
 * ���ͣ�
 * ���п��ܵ����Ϊ��
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * ��ע�⣬˳��ͬ�����б�������ͬ����ϡ�
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
         * �� 1��i��target ʱ���������һ�����У����е�Ԫ��֮�͵��� i��������е����һ��Ԫ��һ�������� nums �е�һ��Ԫ�ء�
         * ��������е����һ��Ԫ���� num����һ���� num��i������Ԫ��֮�͵��� i?num ��ÿһ�����У�
         * �������� num ֮�󼴿ɵõ�һ��Ԫ��֮�͵��� i �����У�����ڼ��� dp[i] ʱ��Ӧ�ü������е� dp[i?num] ֮�͡�
         *
         */
        // dp[i] ��ʾ�ܺ�Ϊ i �������
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
