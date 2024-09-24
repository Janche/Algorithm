package leetcode.dp;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额
 *
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/23
 */
public class _337DpRob3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(3));
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int res = rob(root);
        System.out.println(res);
    }

    public static int rob(TreeNode root) {
        // 返回一个大小为 2 的数组
        int[] res = robTree(root);
        // res[0] 表示 root 被偷的情况下，root 的子树能偷到的最高金额
        // res[1] 表示 root 没被偷的情况下，root 的子树能偷到的最高金额
        return Math.max(res[0], res[1]);
    }

    private static int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        return ((TreeNode) obj).val == this.val;
    }
}
