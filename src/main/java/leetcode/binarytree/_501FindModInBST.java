package leetcode.binarytree;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 */

public class _501FindModInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(5));
        root.right = new TreeNode(5, new TreeNode(4), new TreeNode(5));
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
        List<Integer> res = new LinkedList<>();
//        dfsSearchBST(root, res);
        bfsSearchBST(root, res);
        int[] arr = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            arr[j] = res.get(j);
        }
        System.out.println(Arrays.toString(Arrays.stream(arr).toArray()));
    }

    static TreeNode pre = null;
    static int maxCount = 0;
    static int count = 0;
    public static void dfsSearchBST(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfsSearchBST(root.left, res);
        if (pre != null && pre.val == root.val) {
           count++;
        } else {
            count = 1;
        }
        if (maxCount < count) {
            res.clear();
            res.add(root.val);
            maxCount = count;
        } else if (maxCount == count) {
            res.add(root.val);
        }
        pre = root;
        dfsSearchBST(root.right, res);
    }

    public static void bfsSearchBST(TreeNode root, List<Integer> res) {
        if (root == null) return;
        int count = 0;
        int maxCount = 0;
        TreeNode cur = root;
        TreeNode pre = null;
        Deque<TreeNode> que = new LinkedList<>();
        while (!que.isEmpty() || cur != null) {
            if (cur != null) {
                que.push(cur);
                cur = cur.left;
            } else {
                cur = que.pop();
                if (pre != null && pre.val == cur.val) {
                    count++;
                } else {
                    count = 1;
                }
                if (maxCount < count) {
                    res.clear();
                    res.add(cur.val);
                    maxCount = count;
                } else if (maxCount == count) {
                    res.add(cur.val);
                }
                pre  = cur;
                cur = cur.right;
            }
        }
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            System.out.print(node.val + " ");
            traverse(node.left);
            traverse(node.right);
        }
    }
}


