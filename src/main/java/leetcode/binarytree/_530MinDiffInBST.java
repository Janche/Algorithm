package leetcode.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 */

public class _530MinDiffInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(6));
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
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
        dfsSearchBST(root);
        System.out.println(diff);

    }

    private static int diff = Integer.MAX_VALUE;
    public static void dfsSearchBST(TreeNode root) {
        if (root == null) {
            return;
        }

        dfsSearchBST(root.left);
        if (pre != null) {
            diff = Math.min(diff, root.val - pre.val);
        }
        pre = root;
        dfsSearchBST(root.right);
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


