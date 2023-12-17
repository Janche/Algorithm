package leetcode.binarytree;

/**
 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�
 * �ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q��
 * ����������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����
 *
 * ���磬�������¶���������:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * ʾ�� 1:
 * ����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * ���: 6
 * ����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��
 */

public class _235LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(2), new TreeNode(8));
        root.left = new TreeNode(2, new TreeNode(0), new TreeNode(4));
        root.right = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        root.left.right = new TreeNode(4, new TreeNode(3), new TreeNode(5));
//        TreeNode node = dfsSearch(root, new TreeNode(3), new TreeNode(5));
        TreeNode node = bfsSearch(root, new TreeNode(3), new TreeNode(5));
//        traverse(node);
        System.out.println(node.val);
    }

    public static TreeNode dfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int val = root.val;
        if (val > p.val && val > q.val) {
            TreeNode left = dfsSearch(root.left, p, q);
            if (left != null) {
                return left;
            }
        } else if (val < p.val && val < q.val) {
            TreeNode right = dfsSearch(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }

    public static TreeNode bfsSearch(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            int val = root.val;
            if (val > p.val && val > q.val) {
                root = root.left;
            } else if (val < p.val && val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }

}


