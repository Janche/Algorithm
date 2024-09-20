package leetcode.dp;

/**
 * ����һ���������� coins ����ʾ��ͬ����Ӳ�ң��Լ�һ������ amount ����ʾ�ܽ�
 * ���㲢���ؿ��Դճ��ܽ������� ���ٵ�Ӳ�Ҹ��� �����û���κ�һ��Ӳ�����������ܽ����� -1 ��
 * �������Ϊÿ��Ӳ�ҵ����������޵ġ�
 *
 * ʾ�� 1��
 *
 * ���룺coins = [1, 2, 5], amount = 11
 * �����3
 * ���ͣ�11 = 5 + 5 + 1
 * ʾ�� 2��
 *
 * ���룺coins = [2], amount = 3
 * �����-1
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/20
 */
public class _322DpCashChange1 {
    public static void main(String[] args) {
        int res = coinChange(new int[]{2}, 3);
        System.out.println(res);
//        System.out.println(coinChange(new int[]{1}, 0));
    }

    public static int coinChange(int[] coins, int amount) {

        // dp[i] ��ʾ�ճ��ܽ��Ϊ i ������Ӳ�Ҹ���
        int[] dp = new int[amount + 1];

        // ��ʼ��
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE - 1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }
}
