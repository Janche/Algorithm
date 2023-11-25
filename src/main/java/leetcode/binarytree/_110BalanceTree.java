package leetcode.binarytree;

/**
 * @author: lirong
 * @date: 2023/8/10
 * @description:
 */
public class _110BalanceTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(4);

        System.out.println(getHeight(node));
    }

    public static boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return height > 0;
    }

    private static int getHeight(TreeNode root) {
        int height = 0;
        if (root == null) return height;
        int leftHeight = getHeight(root.left);
//        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(root.right);
//        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
