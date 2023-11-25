package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lirong
 * @date: 2023/7/24
 * @description:
 */
public class _102LevelOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        List<List<Integer>> res = levelOrder(node);
        res.forEach(System.out::println);

        dfsLevelOrder(node, 0);
        resList.forEach(System.out::println);
    }

    private static List<List<Integer>> levelOrder(TreeNode node) {
        List<List<Integer>> res = new ArrayList<>();
        if (node == null) return res;
        Deque<TreeNode> que = new LinkedList<>();
        que.offer(node);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode n = que.poll();
                list.add(n.val);
                if (null != n.left) {
                    que.offer(n.left);
                }
                if (null != n.right) {
                    que.offer(n.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }

    public static List<List<Integer>> resList = new ArrayList<>();

    private static void dfsLevelOrder(TreeNode node, int deep) {
        if (node == null) return;
        deep++;
        if (resList.size() < deep) {
            List<Integer> list = new ArrayList<>();
            resList.add(list);
        }
        resList.get(deep - 1).add(node.val);
        dfsLevelOrder(node.left, deep);
        dfsLevelOrder(node.right, deep);
    }
}
