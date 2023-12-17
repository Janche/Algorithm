package leetcode.binarytree;

/**
 * Define binary tree
 * @author: lirong
 * @date: 2023/7/24
 * @description:
 */
public class TreeNode {
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