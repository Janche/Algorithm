package leetcode;

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
        reverse(node);
        recoverTree(node, 0, 0);
        System.out.println(a+", "+b);
        // reverse(recoverNode);
    }

    static int[] arr = new int[3];
    static int a = 0;
    static int b = 0;

    private static int recoverTree(TreeNode node, int leftMax, int rightMin) {
        if (null == node){
            return 0;
        }
        int leftVal = recoverTree(node.left, leftMax, rightMin);
        int val = node.val;
        leftMax = val;
        if (leftVal != 0 && val < leftVal){
            a = val;
        }
        rightMin = leftVal;
        int rightVal = recoverTree(node.right, leftMax, rightMin);

        if (rightVal != 0 && val > rightVal){
            b = val;
        }

        if (val > rightMin || val < leftMax){
            System.out.println();
            System.out.print(leftVal);
            System.out.print(val);
            System.out.print(rightVal);
            System.out.println();
        }
        return node.val;
    }

    private static void reverse(TreeNode node) {
        if (null != node){
            System.out.println(node.val);
            reverse(node.left);
            reverse(node.right);
        }
    }
}
