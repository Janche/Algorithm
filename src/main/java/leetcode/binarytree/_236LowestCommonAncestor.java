package leetcode.binarytree;

/**
 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T �������ڵ� p��q������������ȱ�ʾΪһ���ڵ� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ʾ�� 1��
 * ���룺root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * �����3
 * ���ͣ��ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3 ��
 */

public class _236LowestCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5), new TreeNode(1));
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        root.left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode node = dfsSearch(root, new TreeNode(5), new TreeNode(1));
//        traverse(node);
        System.out.println(node.val);
    }

    public static TreeNode dfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.equals(q) || root.equals(p)) {
            return root;
        }

        TreeNode left = dfsSearch(root.left, p, q);
        TreeNode right = dfsSearch(root.right, p, q);
        // �нڵ㴦��
        if (right != null && left != null) {
            return root;
        } else if (right != null) {
            return right;
        } else if (left != null) {
            return left;
        } else {
            return null;
        }
    }
}


