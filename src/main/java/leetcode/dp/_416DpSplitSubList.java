package leetcode.dp;

import java.util.Arrays;

/**
 * @Description:
 * @Auther: lirong
 * @Date: 2025/02/06
 * ����һ�� ֻ���������� �� �ǿ� ���� nums �������ж��Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺nums = [1,5,11,5]
 * �����true
 * ���ͣ�������Էָ�� [1, 5, 5] �� [11] ��
 * ʾ�� 2��
 *
 * ���룺nums = [1,2,3,5]
 * �����false
 * ���ͣ����鲻�ָܷ������Ԫ�غ���ȵ��Ӽ���
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
        // dp[i][j] ��ʾǰ i �������ܷ��ҵ���Ϊ j ���Ӽ�
        boolean[][] dp = new boolean[len + 1][target + 1];
        // ��ʼ��
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // ѡ���߲�ѡ
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

        // dp[i] ��ʾ��Ϊ i ���Ӽ��Ƿ����
        int[] dp = new int[target + 1];

        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // ��Ʒ i �������� nums[i]�����ֵҲ�� nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // ��� dp[target] == target��˵���ҵ��˺�Ϊ target ���Ӽ�
            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }
}
