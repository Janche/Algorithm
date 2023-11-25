package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/8/6
 * @description:
 */
public class _222CountNodes {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
//        System.out.println(countNodes(node));
//        System.out.println(countNodesBFS(node));
        System.out.println(countWhole(node));

        System.out.println( (int) (Math.pow(2, 0) - 1));
    }

    public static int countNodes(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static int countNodesBFS(TreeNode root) {
        int count = 0;
        if (root == null) return count;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                count++;
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
        return count;
    }

    public static int countWhole(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }
        while (right != null) {
            rightDepth++;
            right = right.right;
        }

        if (leftDepth == rightDepth) {
            return (2 << leftDepth) - 1;
//            return (int) (Math.pow(2, leftDepth+1) - 1);
        }
        return countWhole(root.left) + countWhole(root.right) + 1;
    }


}
