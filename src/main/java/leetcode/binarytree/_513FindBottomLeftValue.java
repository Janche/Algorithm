package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/10/21
 * @description:
 */
public class _513FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2),
                new TreeNode(3));
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(9);

//        bottomLeftValue(root, 0);
        bfsSumOfLeftLeaves(root);
        System.out.println(result);
//        sumOfLeftLeaves = bfsSumOfLeftLeaves(root);
//        System.out.println(sumOfLeftLeaves);
//        sumOfLeftLeaves = bfsSumOfLeftLeaves2(root);
//        System.out.println(sumOfLeftLeaves);
    }

    private static void bfsSumOfLeftLeaves(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            depth++;
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (maxDepth < depth) {
                    maxDepth = depth;
                    result = node.val;
                }
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
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

    static int maxDepth = 0;
    static int result = 0;
    private static void bottomLeftValue(TreeNode root, int depth) {
        if (root == null) return;
        bottomLeftValue(root.left, depth + 1);
        bottomLeftValue(root.right, depth + 1);
        if (maxDepth <= depth) {
            maxDepth = depth;
            if (root.left == null && root.right == null) {
                result = root.val;
            }
        }
    }
}
