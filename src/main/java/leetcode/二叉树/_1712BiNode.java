package leetcode.������;

/**
 * @author lirong
 * @ClassName: _1712BiNode
 * @Description: ���������ݽṹTreeNode��������ʾ������������left�ÿգ�rightΪ��һ������ڵ㣩��ʵ��һ���������Ѷ���������ת��Ϊ��������Ҫ��ֵ��˳�򱣳ֲ��䣬ת������Ӧ��ԭַ�ģ�Ҳ������ԭʼ�Ķ�����������ֱ���޸ġ�
 * ���룺 [4,2,5,1,3,null,6,0]
 * ����� [0,null,1,null,2,null,3,null,4,null,5,null,6]
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
