package leetcode.binarytree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lirong
 * @desc 105. �Ӻ���������������й��������
 * ǰ����� postorder =[3,9,20,15,7]
 * ������� inorder = [9,3,15,20,7]
 * �������µĶ�������
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * @date 2020/04/12 22:52
 */

public class _106BuildTwoTree {

    static Map<Integer, Integer> map = new HashMap<>();
    static int[] postorder = {3,9,20,15,7};
    static int[] inorder = {9,3,15,20,7};
    static int idx = 0;

    public static void main(String[] args) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        // TreeNode node = dfs(0, inorder.length);
        // traverse(node);
        TreeNode node = buildTreeHelper(postorder, 0, postorder.length - 1, 0, inorder.length - 1, map);
        traverse(node);
    }

    public static TreeNode buildTreeHelper(int[] postorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> map) {
        if(pEnd < pStart || iEnd < iStart) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd]);
        Integer midIndex = map.get(root.val);
        // �������� = �����������ڵ�(�������ڵ��о����Żᵽ�������Ľڵ�) + �����������ڵ� + ͷ���
        // �������������ұ߽� = pStart + leftTotal - 1
        // leftTotal = midIndex - iStart
        root.left = buildTreeHelper(postorder, pStart, pStart + midIndex - iStart - 1, iStart, midIndex - 1, map);
        root.right = buildTreeHelper(postorder, pStart + midIndex - iStart, pEnd - 1, midIndex + 1, iEnd, map);
        return root;
    }

    private static TreeNode dfs(int left, int right) {
        if (left == right){
            return null;
        }
        if (idx == postorder.length){
            return null;
        }
        int val = postorder[idx++];
        TreeNode node = new TreeNode(val);
        Integer middle = map.get(val);
        node.left = dfs(left, middle);
        node.right = dfs(middle+1, right);
        return node;
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            traverse(node.left);
            traverse(node.right);
            System.out.print(node.val + " ");
        }
    }
}


