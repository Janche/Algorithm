package leetcode.������;

/**
 * @author lirong
 * @desc ����һ���ǿն����������������·���͡�
 *
 * �����У�·��������Ϊһ������������ڵ�������ﵽ����ڵ�����С���·�����ٰ���һ���ڵ㣬�Ҳ�һ���������ڵ㡣
 *
 * ʾ�� 1:
 *
 * ����: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * ���: 6
 * @date 2020/04/11 23:51
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class _124TwoTreeMaxLength {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        TreeNode node1 = node.left = new TreeNode(9);
        TreeNode node2 = node.right = new TreeNode(20);
        node2.left = new TreeNode(15);
        node2.right = new TreeNode(7);
        int i = maxPathSum(node);
        System.out.println(ans);
    }
    public static int maxPathSum(TreeNode root) {
        int maxSum = 0;
        return reverse(root);
    }

    public static int ans = 0;
    private static int reverse(TreeNode node) {
        if (node == null){
            return 0;
        }
        // maxSum = Math.max(maxSum, maxSum + node.val);
        int left = Math.max(0, reverse(node.left));
        int right = Math.max(0, reverse(node.right));
        ans = Math.max(ans, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}


