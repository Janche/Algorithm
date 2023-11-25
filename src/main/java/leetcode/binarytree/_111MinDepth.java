package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/8/6
 * @description:
 */
public class _111MinDepth {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(minDepthBFS(node));
    }

    public static int minDepthDFS(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        if (root.left != null && root.right == null) {
            return minDepthDFS(root.left) + 1;
        }
        if (root.right != null && root.left == null) {
            return minDepthDFS(root.right) + 1;
        }

        return Math.min(minDepthDFS(root.left), minDepthDFS(root.right)) + 1;
    }

    public static int minDepthBFS(TreeNode root) {
        int depth = 0;
        if (root == null) return depth;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            depth++;
            int size = que.size();
            while (size-- > 0) {
                TreeNode node = que.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null){
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
