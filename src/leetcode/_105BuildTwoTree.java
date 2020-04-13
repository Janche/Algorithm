package leetcode;

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
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        // dfs(preorder, inorder);
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    private static TreeNode dfs(int left_index, int right_index) {
        if (left_index == right_index){
            return null;
        }
        int val = preorder[idx++];
        int middle = map.get(val);
        TreeNode root = new TreeNode(val);
        root.left = dfs(left_index, middle);
        root.right = dfs(middle+1, right_index);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length);
    }
}


