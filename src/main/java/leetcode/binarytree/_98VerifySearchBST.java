package leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 输入：root = [2,1,3]
 * 输出：true
 */

public class _98VerifySearchBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(4));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(8));
//        TreeNode node = searchBST(root, 2);
//        root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        boolean isValidSearchBST =  dfsSearchBST(root);
//        dfsSearchBST2(root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) {
//                System.out.println(false);
//            }
//        }
        System.out.println(dfsSearchBST3(root));

    }

    private static long minVal = Long.MIN_VALUE;
    public static boolean dfsSearchBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = dfsSearchBST(root.left);
        if (minVal < root.val) {
            minVal = root.val;
        } else {
            return false;
        }
        boolean right = dfsSearchBST(root.right);
        return left && right;
    }

    static List<Integer> list = new LinkedList<>();
    public static TreeNode dfsSearchBST2(TreeNode root) {
        if (root == null) {
            return root;
        }

        dfsSearchBST2(root.left);
        list.add(root.val);
        dfsSearchBST2(root.right);
        return root;
    }

    static TreeNode pre = null;
    public static boolean dfsSearchBST3(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = dfsSearchBST3(root.left);
        if (pre != null && pre.val > root.val) {
           return false;
        }
        pre = root;
        boolean right = dfsSearchBST3(root.right);
        return left && right;
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


