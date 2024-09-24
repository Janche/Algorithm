package leetcode.dp;

/**
 * С͵�ַ�����һ���µĿ����Եĵ������������ֻ��һ����ڣ����ǳ�֮Ϊ root ��
 * ���� root ֮�⣬ÿ����������ֻ��һ��������������֮������һ�����֮�󣬴�����С͵��ʶ��������ط������з��ݵ�����������һ�ö���������
 * ��� ����ֱ�������ķ�����ͬһ�����ϱ���� �����ݽ��Զ�������
 * ������������ root ������ �ڲ���������������� ��С͵�ܹ���ȡ����߽��
 *
 * @Description:
 * @Auther: lirong
 * @Date: 2024/09/23
 */
public class _337DpRob3 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(3));
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int res = rob(root);
        System.out.println(res);
    }

    public static int rob(TreeNode root) {
        // ����һ����СΪ 2 ������
        int[] res = robTree(root);
        // res[0] ��ʾ root ��͵������£�root ��������͵������߽��
        // res[1] ��ʾ root û��͵������£�root ��������͵������߽��
        return Math.max(res[0], res[1]);
    }

    private static int[] robTree(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = robTree(root.left);
        int[] right = robTree(root.right);
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object obj) {
        return ((TreeNode) obj).val == this.val;
    }
}
