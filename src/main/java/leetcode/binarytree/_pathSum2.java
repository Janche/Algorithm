package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lirong
 * @date: 2023/10/29
 * @description:
 */
public class _pathSum2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(8));
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.right = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        root.right.left = new TreeNode(13);

//        pathSumDFS(root, 22, new ArrayList<>());
//        pathSumDFS2(root, 22, new ArrayList<>());
        pathSumBFS(root, 22);
        System.out.println(sumArr);
    }

    private static List<List<Integer>> sumArr = new ArrayList<>();

    public static void pathSumDFS(TreeNode root, int targetSum, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                sumArr.add(new ArrayList<>(arr));
            }
            return;
        }
        if (root.left != null) {
            pathSumDFS(root.left, targetSum - root.val, arr);
            arr.remove(arr.size() - 1);
        }
        if (root.right != null) {
            pathSumDFS(root.right, targetSum - root.val, arr);
            arr.remove(arr.size() - 1);
        }
    }

    public static void pathSumDFS2(TreeNode root, int targetSum, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                sumArr.add(new ArrayList<>(arr));
            }
            arr.remove(arr.size() - 1);
            return;
        }
        pathSumDFS2(root.left, targetSum - root.val, arr);
        pathSumDFS2(root.right, targetSum - root.val, arr);
        arr.remove(arr.size() - 1);
    }

    public static void pathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return;
        Deque<TreeNode> queNode = new LinkedList<>();
        Deque<Integer> queRes = new LinkedList<>();
        Deque<List<Integer>> quePath = new LinkedList<>();
        queNode.push(root);
        queRes.push(root.val);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        quePath.push(rootList);
        while (!queNode.isEmpty()) {
            TreeNode node = queNode.pop();
            Integer res = queRes.pop();
            List<Integer> list = quePath.pop();
            if (node.left == null && node.right == null && res == targetSum) {
                sumArr.add(list);
            }
            if (node.left != null) {
                queNode.push(node.left);
                queRes.push(res + node.left.val);
                list.add(node.left.val);
                quePath.push(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            if (node.right != null) {
                queNode.push(node.right);
                queRes.push(res + node.right.val);
                list.add(node.right.val);
                quePath.push(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
        }
    }
}
