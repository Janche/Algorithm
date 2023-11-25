package leetcode.binarytree;

import java.util.*;

/**
 * @author: lirong
 * @date: 2023/7/19
 * @description:
 */
public class SearchBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, new TreeNode(2));
        root.right.left = new TreeNode(3);
        List<Integer> res = new ArrayList<>();
        preOrderSearch3(res, root);
//        inOrderSearch(res, root);
//        postOrderSearch(res, root);
        res.forEach(System.out::println);
    }

    public static List<Integer> preOrderSearch(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return res;
    }

    private static List<Integer> preOrderSearch2(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node) {
                if (null != node.right) {
                    stack.push(node.right);
                }
                if (null != node.left) {
                    stack.push(node.left);
                }
                stack.push(node);
                stack.push(null);
            } else {
                TreeNode midNode = stack.pop();
                res.add(midNode.val);
            }
        }
        return res;
    }

    private static List<Integer> preOrderSearch3(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    private static List<Integer> inOrderSearch3(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        TreeNode predecessor = null;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    private static List<Integer> inOrderSearch(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    private static List<Integer> inOrderSearch2(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node) {
                if (null != node.right) {
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if (null != node.left) {
                    stack.push(node.left);
                }
            } else {
                TreeNode midNode = stack.pop();
                res.add(midNode.val);
            }
        }
        return res;
    }

    private static List<Integer> postOrderSearch(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        Collections.reverse(res);
        return res;
    }

    private static List<Integer> postOrderSearch2(List<Integer> res, TreeNode root) {
        if (null == root) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node) {
                stack.push(node);
                stack.push(null);
                if (null != node.right) {
                    stack.push(node.right);
                }
                if (null != node.left) {
                    stack.push(node.left);
                }
            } else {
                TreeNode midNode = stack.pop();
                res.add(midNode.val);
            }
        }
        return res;
    }

}

