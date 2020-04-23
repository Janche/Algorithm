package leetcode.二叉树;

/**
 * @author lirong
 * @desc 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
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


