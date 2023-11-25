package leetcode.binarytree;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * @date 2020/04/12 22:52
 */

public class _654BuildMaxTree {

    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
//        TreeNode node = dfsBuildTree(nums);
        TreeNode node = dfsBuildTree2(nums, 0, nums.length);
        traverse(node);
    }

    private static TreeNode dfsBuildTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int maxVal = -1;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        if (maxIndex > 0) {
            int[] leftNums = new int[maxIndex];
            for (int i = 0; i < maxIndex; i++) {
                leftNums[i] = nums[i];
            }
            root.left = dfsBuildTree(leftNums);
        }
        if (maxIndex < nums.length - 1) {
            int rightLen = nums.length - 1 - maxIndex;
            int[] rightNums = new int[rightLen];
            for (int i = 0; i < rightLen; i++) {
                rightNums[i] = nums[i + maxIndex + 1];
            }
            root.right = dfsBuildTree(rightNums);
        }
        return root;
    }

    private static TreeNode dfsBuildTree2(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int maxVal = -1;
        int maxIndex = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        if (maxIndex > start) {
            root.left = dfsBuildTree2(nums, start, maxIndex);
        }
        if (maxIndex < end - 1) {
            root.right = dfsBuildTree2(nums, maxIndex + 1, end);
        }
        return root;
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            traverse(node.left);
            System.out.print(node.val + " ");
            traverse(node.right);
        }
    }
}


