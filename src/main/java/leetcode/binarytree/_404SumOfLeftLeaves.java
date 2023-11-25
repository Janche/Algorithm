package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/10/21
 * @description:
 */
public class _404SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        int sumOfLeftLeaves = sumOfLeftLeaves(root);
        System.out.println(sumOfLeftLeaves);
        sumOfLeftLeaves = bfsSumOfLeftLeaves(root);
        System.out.println(sumOfLeftLeaves);
        sumOfLeftLeaves = bfsSumOfLeftLeaves2(root);
        System.out.println(sumOfLeftLeaves);
    }

    private static int bfsSumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int result = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        result += node.left.val;
                    }
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return result;
    }

    private static int bfsSumOfLeftLeaves2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int result = 0;
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null) {
                que.offer(node.left);
                if (node.left.left == null && node.left.right == null) {
                    result += node.left.val;
                }
            }
            if (node.right != null) {
                que.offer(node.right);
            }

        }
        return result;
    }

    private static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 0;
        }
        int midSum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midSum = root.left.val;
        }
        midSum += sumOfLeftLeaves(root.left);
        midSum += sumOfLeftLeaves(root.right);
        return midSum;
    }


}
