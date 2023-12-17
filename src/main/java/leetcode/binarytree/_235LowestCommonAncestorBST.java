package leetcode.binarytree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * 示例 1:
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 */

public class _235LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(2), new TreeNode(8));
        root.left = new TreeNode(2, new TreeNode(0), new TreeNode(4));
        root.right = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        root.left.right = new TreeNode(4, new TreeNode(3), new TreeNode(5));
//        TreeNode node = dfsSearch(root, new TreeNode(3), new TreeNode(5));
        TreeNode node = bfsSearch(root, new TreeNode(3), new TreeNode(5));
//        traverse(node);
        System.out.println(node.val);
    }

    public static TreeNode dfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int val = root.val;
        if (val > p.val && val > q.val) {
            TreeNode left = dfsSearch(root.left, p, q);
            if (left != null) {
                return left;
            }
        } else if (val < p.val && val < q.val) {
            TreeNode right = dfsSearch(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }

    public static TreeNode bfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int val = root.val;
            if (val > p.val && val > q.val) {
                root = root.left;
            } else if (val < p.val && val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

}


