package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/7/30
 * @description:
 */
public class _101SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(2));
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

        boolean flag = isSymmetric(root);
        flag= isSymmetric2(root);
        System.out.println(flag);
    }

    private static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);

    }

    private static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root.left);
        que.offer(root.right);
        while (!que.isEmpty()) {
            TreeNode left = que.poll();
            TreeNode right = que.poll();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null || left.val != right.val) {
                return false;
            }
            que.offer(left.left);
            que.offer(right.right);
            que.offer(left.right);
            que.offer(right.left);
        }
        return true;
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

}
