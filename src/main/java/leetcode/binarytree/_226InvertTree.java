package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lirong
 * @date: 2023/7/27
 * @description:
 */
public class _226InvertTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));
//        invertTreeDFS(root);
        invertTreeBFS(root);
        List<Integer> res = SearchBinaryTree.preOrderSearch(new ArrayList<>(), root);
        res.forEach(System.out::println);
    }

    public static void invertTreeDFS(TreeNode root) {
        if (root == null) return;
        swap(root);
        invertTreeDFS(root.left);
        invertTreeDFS(root.right);
    }

    public static void invertTreeBFS(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                TreeNode node = que.poll();
                swap(node);
                if (null != node.left) {
                    que.offer(node.left);
                }
                if (null != node.right) {
                    que.offer(node.right);
                }
                size--;
            }
        }
    }

    public static void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return res;
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
//            for(Node n: node.children) {
//                stack.push(n);
//            }

            if (null != root.children && root.children.size() > 0) {
                for(int i=root.children.size() - 1; i >=0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
