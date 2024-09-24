package leetcode.dp;

/**
 * ����һ��רҵ��С͵���ƻ�͵���ؽֵķ��ݣ�ÿ�䷿�ڶ�����һ�����ֽ�����ط����еķ��ݶ� Χ��һȦ ������ζ�ŵ�һ�����ݺ����һ�������ǽ����ŵġ�ͬʱ�����ڵķ���װ���໥��ͨ�ķ���ϵͳ������������ڵķ�����ͬһ���ϱ�С͵���룬ϵͳ���Զ����� ��
 * ����һ������ÿ�����ݴ�Ž��ķǸ��������飬������ �ڲ���������װ�õ������ �������ܹ�͵�Ե�����߽�
 * ʾ�� 1��
 * ���룺nums = [2,3,2]
 * �����3
 * ���ͣ��㲻����͵�� 1 �ŷ��ݣ���� = 2����Ȼ��͵�� 3 �ŷ��ݣ���� = 2��, ��Ϊ���������ڵġ�
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/23
 */
public class _213DpRob2 {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));
        System.out.println(rob(new int[]{1, 2, 3, 1}));
    }

    public static int rob(int[] nums) {
       if (nums.length == 1) {
           return nums[0];
       }

       int res1 = rob(nums, 0, nums.length - 2);
       int res2 = rob(nums, 1, nums.length - 1);

       return Math.max(res1, res2);
    }

    public static int rob(int[] nums, int start, int end) {
        int len = end - start + 1;
        if (len <= 1) {
            return nums[start];
        }
        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[len - 1];
    }
}
