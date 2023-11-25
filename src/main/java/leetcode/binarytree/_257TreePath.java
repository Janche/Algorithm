package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lirong
 * @date: 2023/8/13
 * @description:
 */
public class _257TreePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
        System.out.println(traversalBFS(root));
        traversalDFS(root, "");
        System.out.println(res);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<Integer> path = new LinkedList<>();
        traversalDFS(root, path, result);
        return result;
    }

    public static final List<String> res = new ArrayList<>();
    private static void traversalDFS(TreeNode root, String path) {
        if (root == null) return;
        path += root.val;
        if (root.left == null && root.right == null) {
            res.add(path);
        }
        if (root.left != null) {
            traversalDFS(root.left, path + "->");
        }
        if (root.right != null) {
            traversalDFS(root.right, path + "->");
        }
    }

    private static void traversalDFS(TreeNode root, LinkedList<Integer> path, List<String> result) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sPath = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sPath.append(path.get(i)).append("->");
            }
            sPath.append(path.getLast());
            result.add(sPath.toString());
            return;
        }
        if (root.left != null) {
            traversalDFS(root.left, path, result);
            path.removeLast();
        }
        if (root.right != null) {
            traversalDFS(root.right, path, result);
            path.removeLast();
        }
    }

    private static List<String> traversalBFS (TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        Deque<Object> que = new LinkedList<>();
        que.push(root);
        que.push(root.val + "");
        while (!que.isEmpty()) {
            String path = (String) que.pop();
            TreeNode node = (TreeNode) que.pop();
            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.right != null) {
                que.push(node.right);
                que.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                que.push(node.left);
                que.push(path + "->" + node.left.val);
            }
        }
        return result;
    }
}
