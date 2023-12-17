package leetcode.binarytree;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 */

public class _236LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5), new TreeNode(1));
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        root.left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode node = dfsSearch(root, new TreeNode(5), new TreeNode(1));
//        traverse(node);
        System.out.println(node.val);
    }

    public static TreeNode dfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(q) || root.equals(p)) {
            return root;
        }

        TreeNode left = dfsSearch(root.left, p, q);
        TreeNode right = dfsSearch(root.right, p, q);
        // 中节点处理
        if (right != null && left != null) {
            return root;
        } else if (right != null) {
            return right;
        } else if (left != null) {
            return left;
        } else {
            return null;
        }
    }
}


