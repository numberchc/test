package addTwoNumbers;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2021/8/3 12:21 上午
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode target = new ListNode(0);
        return buildList(target, l1, l2);
    }

    private ListNode buildList(ListNode target, ListNode l1, ListNode l2) {
        int val1 = 0;
        if (l1 != null) {
            val1 = l1.val;
        }
        int val2 = 0;
        if (l2 != null) {
            val2 = l2.val;
        }
        if (val1 == 0 && val2 == 0 && target.val == 0) {
            return target;
        }

        int sumVal = val1 + val2 + target.val;
        int curVal = sumVal % 10;
        int nextVal = sumVal / 10;

        target.val = curVal;
        ListNode nextNode = new ListNode(nextVal);
        target.next = nextNode;
        return buildList(nextNode, l1.next, l2.next);
    }

}
