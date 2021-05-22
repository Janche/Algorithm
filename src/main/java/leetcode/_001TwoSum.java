package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lirong
 * @desc
 * ����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ����?����?���������������ǵ������±ꡣ
 *
 * ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء���
 * @date 2019/12/08 17:43
 */

public class _001TwoSum {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] ints = twoSum(nums, 6);
        System.out.println(ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
