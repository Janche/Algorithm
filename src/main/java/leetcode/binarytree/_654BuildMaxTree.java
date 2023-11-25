package leetcode.binarytree;

/**
 * ����һ�����ظ����������� nums �� �������� ������������㷨�� nums �ݹ�ع���:
 *
 * ����һ�����ڵ㣬��ֵΪ nums �е����ֵ��
 * �ݹ�������ֵ ��� �� ������ǰ׺�� ������������
 * �ݹ�������ֵ �ұ� �� �������׺�� ������������
 * ���� nums ������ �������� ��
 * ���룺nums = [3,2,1,6,0,5]
 * �����[6,3,5,null,2,0,null,null,1]
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


