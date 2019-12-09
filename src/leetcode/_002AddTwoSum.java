package leetcode;

/**
 * @author lirong
 * @desc
 * @date 2019/12/08 19:04
 */

public class _002AddTwoSum {

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(6);

        node.next = node1;
        // node1.next = node2;

        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        // node3.next = node4;
        // node4.next = node5;
        // addTwoNumbers(node, node3);

        ListNode startNode = new ListNode(0);
        // dfsNode(startNode, node, node3);
        ListNode listNode = dfs2Node(node, node3);
        printNode(listNode);
    }

    private static ListNode dfs2Node(ListNode node, ListNode node3) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = node, q = node3, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

    private static void printNode(ListNode dfsNode) {
        if (null != dfsNode){
            System.out.println(dfsNode.val);
            printNode(dfsNode.next);
        }
    }


    private static void dfsNode(ListNode resultNode, ListNode l1, ListNode l2) {
        if (null == l1 && null == l2){
            return;
        }
        int val = resultNode.val;
        val = (null != l1) ? val + l1.val : val;
        val = (null != l2) ? val + l2.val : val;
        if (val >= 10) {
            val = val % 10;
            resultNode.next = new ListNode(1);
        } else {
            if ((null != l1 && null != l1.next) || (null != l2 && null != l2.next)) {
                resultNode.next = new ListNode(0);
            }
        }
        resultNode.val = val;
        dfsNode(resultNode.next, l1 != null ? l1.next : null, l2 != null ? l2.next : null);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
