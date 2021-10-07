package leetcode.twoPointer;

import java.util.Arrays;

public class _977TwoPointer {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
//        int[] nums = {-1};
        System.out.println(Arrays.toString(twoPointer(nums)));
        System.out.println(Arrays.toString(arraySort(nums)));
    }

    public static int[] arraySort(int[] nums){
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }

    public static int[] twoPointer(int[] nums){
        int left = 0;
        int len = nums.length;
        int right = len;
        int index = -1;
        int mid = 0;
        while(left <= right){
            mid = left + ((right - left) >> 1);
            if(mid < len && nums[mid] < 0){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        int[] ans = new int[len];
        left = index;
        right = index + 1;
        int i = 0;
        while(left >= 0 || right < len){
            if(left < 0 || (right < len && -nums[left] >= nums[right])){
                ans[i] = nums[right] * nums[right];
                right++;
            }else if(right == len || (left >= 0 && -nums[left] < nums[right])){
                ans[i] = nums[left] * nums[left];
                left--;
            }
            i++;
        }
//        for(int i=0; i<len; i++){
//            if(left >= 0 && right < len){
//                if(-nums[left] > nums[right]){
//                    ans[i] = nums[right] * nums[right];
//                    right++;
//                }else{
//                    ans[i] = nums[left] * nums[left];
//                    left--;
//                }
//            }else{
//                if(index == len - 1){
//                    ans[i] = nums[len - 1 - i] * nums[len - 1 - i];
//                }else {
//                    ans[i] = nums[i] * nums[i];
//                }
//            }
//        }
        return ans;
    }
}
