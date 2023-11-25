package leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������ö������� root1 �� root2 ��
 * ����һ�£����㽫����һ�ø��ǵ���һ��֮��ʱ���������ϵ�һЩ�ڵ㽫���ص�������һЩ���ᣩ������Ҫ�����������ϲ���һ���¶��������ϲ��Ĺ����ǣ���������ڵ��ص�����ô���������ڵ��ֵ�����Ϊ�ϲ���ڵ����ֵ�����򣬲�Ϊ null �Ľڵ㽫ֱ����Ϊ�¶������Ľڵ㡣
 * ���غϲ���Ķ�������
 *
 * ע��: �ϲ����̱�����������ĸ��ڵ㿪ʼ��
 * ���룺root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * �����[3,4,5,5,4,null,7]
 */

public class _617MergeTwoTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        root1.left.left = new TreeNode(5);
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        TreeNode node = bfsMergeTrees(root1, root2);
        traverse(node);
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    public static TreeNode bfsMergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 ==null) return root1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            // ��ʱ�����ڵ�һ����Ϊ�գ�val���
            node1.val = node1.val + node2.val;
            // �����������ڵ㶼��Ϊ�գ��������
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            }
            // ����������ҽڵ㶼��Ϊ�գ��������
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            }
            // ��node1����ڵ�Ϊ�գ�ֱ�Ӹ�ֵ
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            // ��node1���ҽڵ�Ϊ�գ�ֱ�Ӹ�ֵ
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }

    private static void traverse(TreeNode node) {
        if (null != node){
            System.out.print(node.val + " ");
            traverse(node.left);
            traverse(node.right);
        }
    }
}


