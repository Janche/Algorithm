package leetcode.dp;

/**
 * ����һ���������� coins ��ʾ��ͬ����Ӳ�ң����һ������ amount ��ʾ�ܽ�
 *
 * ������㲢���ؿ��Դճ��ܽ���Ӳ�������������κ�Ӳ����϶��޷��ճ��ܽ����� 0 ��
 *
 * ����ÿһ������Ӳ�������޸���
 *
 * ��Ŀ���ݱ�֤������� 32 λ������������
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺amount = 5, coins = [1, 2, 5]
 * �����4
 * ���ͣ������ַ�ʽ���Դճ��ܽ�
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * ʾ�� 2��
 *
 * ���룺amount = 3, coins = [2]
 * �����0
 * ���ͣ�ֻ����� 2 ��Ӳ�Ҳ��ܴճ��ܽ�� 3
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/19
 */
public class _518DpCashChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int res = change(amount, coins);
        res = change2(amount, coins);
        System.out.println(res);
    }

    public static int change(int amount, int[] coins) {
        // dp[i] ��ʾ�ճ��ܽ��Ϊ i ��Ӳ�������
        int[] dp = new int[amount + 1];

        // ֻ�е���ѡȡ�κ�Ӳ��ʱ�����֮�Ͳ�Ϊ 0�����ֻ�� 1 ��Ӳ�����
        dp[0] = 1;
        // �����ȱ��� coins���ٱ��� amount��������������� �����������������
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                // dp[i] ��ʾ�ճ��ܽ��Ϊ i ��Ӳ�������
                // dp[i] = dp[i] + dp[i - coin]
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static int change2(int amount, int[] coins) {
        // dp[i][j] ��ʾǰ i ��Ӳ�Ҵճɽ�� j �������
        int[][] dp = new int[coins.length][amount+1];

        // ��ʼ���߽�ֵ
        for(int i = 0; i < coins.length; i++){
            // ��һ�еĳ�ʼֵΪ1
            dp[i][0] = 1;
        }
        for(int j = coins[0]; j <= amount; j++){
            // ��ʼ����һ��
            dp[0][j] += dp[0][j-coins[0]];
        }

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j <= amount; j++){
                if(j < coins[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j];
            }
        }

        return dp[coins.length-1][amount];
    }
}
