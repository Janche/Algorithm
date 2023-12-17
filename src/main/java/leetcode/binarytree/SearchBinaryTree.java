package leetcode.binarytree;

import java.util.*;

/**
 * @author: lirong
 * @date: 2023/7/19
 * @description:
 */
public class SearchBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, new TreeNode(5), new TreeNode(2));
        root.right.left = new TreeNode(3);
        List<Integer> res = new ArrayList<>();
//        preOrderUnitySearch(res, root);
//        inOrderUnitySearch(res, root);
//        postOrderUnitySearch(res, root);
//        preOrderSearch3(res, root);
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

    private static List<Integer> preOrderUnitySearch(List<Integer> res, TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        while (!que.isEmpty()) {
            TreeNode node = que.pop();
            if (node != null) {
                if (null != node.right) {
                    que.push(node.right);
                }
                if (null != node.left) {
                    que.push(node.left);
                }
                que.push(node);
                que.push(null); // 中节点进栈前，先用null标记下
            } else { // 当前节点为null，则下一个节点就是中节点
                TreeNode midNode = que.pop();
                res.add(midNode.val);
            }
        }
        return res;
    }

    private static List<Integer> inOrderUnitySearch(List<Integer> res, TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        while (!que.isEmpty()) {
            TreeNode node = que.pop();
            if (node != null) {
                if (null != node.right) {
                    que.push(node.right);
                }
                que.push(node);
                que.push(null); // 中节点进栈前，先用null标记下
                if (null != node.left) {
                    que.push(node.left);
                }
            } else { // 当前节点为null，则下一个节点就是中节点
                TreeNode midNode = que.pop();
                res.add(midNode.val);
            }
        }
        return res;
    }

    private static List<Integer> postOrderUnitySearch(List<Integer> res, TreeNode root) {
        if (root == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root);
        while (!que.isEmpty()) {
            TreeNode node = que.pop();
            if (node != null) {
                que.push(node);
                que.push(null); // 中节点进栈前，先用null标记下
                if (null != node.right) {
                    que.push(node.right);
                }
                if (null != node.left) {
                    que.push(node.left);
                }
            } else { // 当前节点为null，则下一个节点就是中节点
                TreeNode midNode = que.pop();
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
}

