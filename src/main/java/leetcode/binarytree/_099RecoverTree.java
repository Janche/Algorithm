package leetcode.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lirong
 * @ClassName: _099RecoverTree
 * @Description: 二叉搜索树中的两个节点被错误地交换。
 * @date 2020-04-21 17:07
 * 请在不改变其结构的情况下，恢复这棵树。
 * 输入: [1,3,null,null,2]
 *
 * ?  1
 * ? /
 * ?3
 * ? \
 * ?  2
 *
 * 输出: [3,1,null,null,2]
 *
 * ?  3
 * ? /
 * ?1
 * ? \
 * ?  2
 */
public class _099RecoverTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.right = new TreeNode(4);
        node.right.left = new TreeNode(2);
        List<Integer> list = new ArrayList<>();
        inorder(node,list);
        int[] twoSwapped = findTwoSwapped(list);
        System.out.println();
        Arrays.stream(twoSwapped).forEach(System.out::print);
        reverse(node, twoSwapped);
        System.out.println();
        inorder(node,list);
    }

    private static void reverse(TreeNode node, int[] arr) {
        if (null == node) return;
        int val = node.val;
        if (val == arr[0]){
            node.val = arr[1];
        }else if(val == arr[1]){
            node.val = arr[0];
        }
        reverse(node.left, arr);
        reverse(node.right, arr);
    }

    public static void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)){
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                }else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    static TreeNode x, y, pred;

    /**
     * 直接找出两个需要交换的节点
     * @param root
     */
    public static void findTwoSwapped(TreeNode root) {
        if (null == root) return;
        findTwoSwapped(root.left);
        if (pred != null && pred.val > root.val){
            y = root;
            if (x == null) x = pred;
            else return;
        }
        pred = root;
        findTwoSwapped(root.right);
    }

    public static void swap(TreeNode a, TreeNode b){
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }

    public static void reverse(TreeNode root) {
       findTwoSwapped(root);
       swap(x, y);
    }
}
