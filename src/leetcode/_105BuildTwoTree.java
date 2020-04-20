package leetcode;

import sun.reflect.generics.tree.Tree;

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
        TreeNode node = dfs(0, inorder.length-1);
        traverse(node);
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


