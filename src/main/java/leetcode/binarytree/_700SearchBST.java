package leetcode.binarytree;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 *
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 */

public class _700SearchBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
//        TreeNode node = searchBST(root, 2);
        TreeNode node = bfsSearchBST(root, 2);
        traverse(node);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static TreeNode bfsSearchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val < val) {
                root = root.right;
            } else if (root.val > val) {
                root = root.left;
            } else {
                return root;
            }
        }

        return null;
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            System.out.print(node.val + " ");
            traverse(node.left);
            traverse(node.right);
        }
    }
}


