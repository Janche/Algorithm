package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/8/6
 * @description:
 */
public class _104MaxDepth {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(maxDepth(node));
    }

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        if (root.left != null) {
            depth = Math.max(maxDepth(root.left), depth);
        }
        if (root.right != null) {
            depth = Math.max(maxDepth(root.right), depth);
        }
        return depth + 1;
    }

    public static int maxDepthBFS(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()){
            depth++;
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return depth;
    }
}
