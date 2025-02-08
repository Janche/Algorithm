package leetcode.dp;

/**
 * ����һ���������ַ������� strs ���������� m �� n ��
 *
 * �����ҳ������� strs ������Ӽ��ĳ��ȣ����Ӽ��� ��� �� m �� 0 �� n �� 1 ��
 *
 * ��� x ������Ԫ��Ҳ�� y ��Ԫ�أ����� x �Ǽ��� y �� �Ӽ� ��
 *
 *
 *
 * ʾ�� 1��
 *
 * ���룺strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * �����4
 * ���ͣ������ 5 �� 0 �� 3 �� 1 ������Ӽ��� {"10","0001","1","0"} ����˴��� 4 ��
 * �����������⵫��С���Ӽ����� {"0001","1"} �� {"10","1","0"} ��{"111001"} ���������⣬��Ϊ���� 4 �� 1 ������ n ��ֵ 3 ��
 * ʾ�� 2��
 *
 * ���룺strs = ["10", "0", "1"], m = 1, n = 1
 * �����2
 * ���ͣ������Ӽ��� {"0", "1"} �����Դ��� 2 ��
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
        // dp[i][j] ��ʾ i �� 0 �� j �� 1 ������Ӽ��ĳ���
        int[][] dp = new int[m + 1][n + 1];
        // �ַ����൱������Ʒ��0 �ĸ����� 1 �ĸ����൱���� ���������� ���������һ�����͵�01�������ȱ�����Ʒ������������������������
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
        // dp[i][j][k] ��ʾ 0~i �� �ַ��� 0 �ĸ���Ϊ j, 1 �ĸ���Ϊ k ������Ӽ��ĳ���
        int[][][] dp = new int[len][m + 1][n + 1];

        // ��ʼ����Ϊ�˱���������ۣ�ͨ��������һ�С����������Ϊ���� 0 ���ַ����ǿմ����� 0 ��Ĭ�ϳ�ʼ��Ϊ 0��
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
