package leetcode.binarytree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lirong
 * @date: 2023/10/29
 * @description:
 */
public class _pathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        root.right.left = new TreeNode(13);
        boolean result = pathSum(root, 22);
//        root = new TreeNode(1, null, null);
        result = pathSum2(root, 22);
        result = pathSum3(root, 22);
        System.out.println(result);
    }

    public static boolean pathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return pathSum(root.left, targetSum - root.val) ||
                pathSum(root.right, targetSum - root.val);
    }

    public static boolean pathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<TreeNode> queNode = new LinkedList<>();
        Deque<Integer> queRes = new LinkedList<>();
        queNode.push(root);
        queRes.push(root.val);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.pop();
            Integer res = queRes.pop();
            if (node.left == null && node.right == null && res == targetSum) {
                return true;
            }
            if (node.left != null) {
                queNode.push(node.left);
                queRes.push(res + node.left.val);
            }
            if (node.right != null) {
                queNode.push(node.right);
                queRes.push(res + node.right.val);
            }
        }
        return false;
    }

    public static boolean pathSum3(TreeNode root, int targetSum) {
        if (root == null) return false;
        Deque<TreeNode> queNode = new LinkedList<>();
        Deque<Integer> queRes = new LinkedList<>();
        queNode.push(root);
        queRes.push(root.val);
        while (!queNode.isEmpty()) {
            int size = queNode.size();
            while (size -- > 0) {
                TreeNode node = queNode.pop();
                Integer res = queRes.pop();
                if (node.left == null && node.right == null && res == targetSum) {
                    return true;
                }
                if (node.left != null) {
                    queNode.push(node.left);
                    queRes.push(res + node.left.val);
                }
                if (node.right != null) {
                    queNode.push(node.right);
                    queRes.push(res + node.right.val);
                }
            }
        }
        return false;
    }
}
