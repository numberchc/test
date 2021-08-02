package addTwoNumbers;

/**
 * TODO
 *
 * @author chenhuichang
 * @date 2021/8/3 12:22 上午
 */
public class AddTwoNumbersMain {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        ListNode a1 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode c1 = new ListNode(4);
        a1.next = b1;
        b1.next = c1;

        Solution solution = new Solution();
        ListNode listNode = solution.addTwoNumbers(a, a1);
        System.out.printf(listNode.val + "," + listNode.next.val + "," + listNode.next.next.val);

    }

}
