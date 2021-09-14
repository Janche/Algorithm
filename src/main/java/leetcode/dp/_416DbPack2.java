package leetcode.dp;

import java.util.Arrays;

public class _416DbPack2 {

    public static void main(String[] args) {
        int[] nums = {1,2,5};
        Boolean bool = getResult(nums);
        System.out.println(bool);
    }

    private static Boolean getResult(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[][] dp = new int[len + 1][target + 1];

        for (int i = 1; i < len; i++) {
            for (int j = target; j <=0; j--) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j - nums[i]] + nums[i]);
            }
        }
        if (dp[len-1][target] == target){
            return true;
        }
        System.out.println(Arrays.toString(dp));

        return false;
    }
}
