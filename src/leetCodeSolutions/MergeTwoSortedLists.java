package leetCodeSolutions;

import java.util.List;

import org.junit.Test;

public class MergeTwoSortedLists {
	@Test
	public void main() {
		// ListNode left = new ListNode(1);
		// ListNode lhead = left;
		// left.next = new ListNode(3);
		// left.next.next = new ListNode(5);
		// left.next.next.next = new ListNode(7);
		// left.next.next.next.next = new ListNode(9);
		ListNode left = null;
		ListNode right = new ListNode(2);
		// ListNode rhead = right;
		// right.next = new ListNode(4);
		// right.next.next = new ListNode(6);
		// right.next.next.next = new ListNode(8);
		// right.next.next.next.next = new ListNode(10);
		// right.next.next.next.next.next = new ListNode(12);
		// right.next.next.next.next.next.next = new ListNode(14);

		ListNode test = new ListNode(0);
		test.next = new ListNode(1);

		ListNode thead = test;
		test = test.next;
		test.next = new ListNode(2);
		test = test.next;
		test.next = new ListNode(3);
		test = test.next;
		test.next = new ListNode(4);
		test = test.next;
		test.next = new ListNode(5);
		test = test.next;
		ListNode result = mergeTwoLists(left, right);
		while (result.next != null) {
			System.out.println(result.val);
			result = result.next;

		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode listNode = null;
		if ((null != l1) || (null != l2)) {
			if (null == l1) {

				listNode = new ListNode(l2.val);
				mergeTwoListsPart(listNode, l1, l2.next);

			} else if (null == l2) {
				listNode = new ListNode(l1.val);
				mergeTwoListsPart(listNode, l1.next, l2);
			} else {
				if (l1.val <= l2.val) {
					listNode = new ListNode(l1.val);
					mergeTwoListsPart(listNode, l1.next, l2);

				} else {
					listNode = new ListNode(l2.val);
					mergeTwoListsPart(listNode, l1, l2.next);
				}
			}

		}
		return listNode;
	}

	public void mergeTwoListsPart(ListNode l, ListNode l1, ListNode l2) {

		if ((null != l1) || (null != l2)) {
			if (null == l1) {

				l.next = new ListNode(l2.val);
				mergeTwoListsPart(l.next, l1, l2.next);

			} else if (null == l2) {
				l.next = new ListNode(l1.val);
				mergeTwoListsPart(l.next, l1.next, l2);
			} else {
				if (l1.val <= l2.val) {
					l.next = new ListNode(l1.val);
					mergeTwoListsPart(l.next, l1.next, l2);

				} else {
					l.next = new ListNode(l2.val);
					mergeTwoListsPart(l.next, l1, l2.next);
				}
			}

		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
