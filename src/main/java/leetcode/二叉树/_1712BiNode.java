package leetcode.二叉树;

/**
 * @author lirong
 * @ClassName: _1712BiNode
 * @Description: 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * @date 2020-04-23 15:41
 */

public class _1712BiNode {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        TreeNode node1 = node.left = new TreeNode(2);
        TreeNode node3 = node1.left = new TreeNode(1);
        node3.left = new TreeNode(0);
        node1.right = new TreeNode(3);
        TreeNode node2 = node.right = new TreeNode(5);
        node2.right = new TreeNode(6);
        TreeNode prev = new TreeNode(-1);
        inorder(node, prev);
        System.out.println("======");
        inorder2(prev.right);
    }

    static TreeNode root = new TreeNode(0);

    private static TreeNode inorder(TreeNode root, TreeNode prev){
        if (root != null){
            prev = inorder(root.left, prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right, prev);
        }
        return prev;
    }

    private static void inorder2(TreeNode node) {
        if (node == null) return;
        inorder2(node.left);
        System.out.println(node.val);
        inorder2(node.right);
    }
}
