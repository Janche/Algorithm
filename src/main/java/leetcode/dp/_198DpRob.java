package leetcode.dp;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݡ�ÿ�䷿�ڶ�����һ�����ֽ�Ӱ����͵�Ե�Ψһ��Լ���ؾ������ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ�������
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ ����������װ�õ������ ��һҹ֮���ܹ�͵�Ե�����߽�
 * ʾ�� 1��
 * ���룺[1,2,3,1]
 * �����4
 * ���ͣ�͵�� 1 �ŷ��� (��� = 1) ��Ȼ��͵�� 3 �ŷ��� (��� = 3)��
 *      ͵�Ե�����߽�� = 1 + 3 = 4 ��
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/23
 */
public class _198DpRob {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return nums[0];
        }
        // dp[i] ��ʾǰ i ��������͵�Ե�����߽��
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];
    }
}
