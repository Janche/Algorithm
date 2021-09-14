package leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirong
 * @desc 105. 从前序与中序遍历序列构造二叉树
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @date 2020/04/12 22:52
 */

public class _105BuildTwoTree {

    static Map<Integer, Integer> map = new HashMap<>();
    static int[] preorder = {3,9,20,15,7};
    static int[] inorder = {9,3,15,20,7};
    static int idx = 0;

    public static void main(String[] args) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // TreeNode node = dfs(0, inorder.length);
        // traverse(node);
        TreeNode node2 = buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
        traverse(node2);
    }

    public static TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end){
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        Integer i_root_index = map.get(root.val);
        int leftNum = i_root_index - i_start;
        root.left = buildTreeHelper(preorder, p_start+1, p_start+leftNum+1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start+leftNum+1, p_end, inorder, i_root_index+1, i_end, map);
        return root;
    }

    private static TreeNode dfs(int left, int right) {
        if (left == right){
            return null;
        }
        if (idx == preorder.length){
            return null;
        }
        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);
        Integer middle = map.get(val);
        node.left = dfs(left, middle);
        node.right = dfs(middle+1, right);
        return node;
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            System.out.print(node.val + " ");
            traverse(node.left);
            traverse(node.right);
        }
    }
}


