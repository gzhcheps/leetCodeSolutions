package leetCodeSolutions;

import java.awt.HeadlessException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class PalindromeLinkedList {
	int allCount = 4;
	@Test
	public void main() {
		ListNode test = new ListNode(allCount/2);
		int count = allCount -1;
		initNode(test,count);
		 
		
		ListNode bug = new ListNode(1);
		bug.next =  new ListNode(1);
		bug.next.next =  new ListNode(0);
		bug.next.next.next =  new ListNode(0);
		bug.next.next.next.next =  new ListNode(1);
		boolean result = isPalindrome(bug);	
		System.out.println(result);
	}
	private void initNode(ListNode node ,int count) {
		if (count == 0) {
			node.next = new ListNode(allCount/2);
		}else {
			node.next =  new ListNode(Math.abs(allCount/2 - count));
			if (count == allCount/2) {
				node.next.next = new ListNode(Math.abs(allCount/2 - count));
				initNode(node.next.next, -- count);
			}else {
				initNode(node.next, -- count);
			}
			
		}
	}
	
	 public boolean isPalindrome(ListNode head) {
		 if (null == head ) {
			return true;
		 }
		 if (null == head.next) {
			return true;
		 }
		 if (null == head.next.next) {
			if (head.val != head.next.val) {
				return false;
			}
			return true;
		 }
		 if (null == head.next.next.next) {
			 if (head.val != head.next.next.val) {
					return false;
				}
				return true;
		 }
	     ListNode slow = head;
	     ListNode quick = head;
	     slow = slow.next;
	     quick = quick.next.next;
	     ListNode p = head;
	     ListNode q = head.next;
		 p.next = null;
		 
	     while (null != q&& null != quick &&null != quick.next) {
	    	 slow = slow.next;
		    	quick = quick.next.next;
ListNode r = q.next;
q.next = p;
p = q;
q= r;
	    	
	    	 
		}	
	    if (null != quick) {
			slow = slow.next;
		}
	    ListNode reverseHead= p;
	    
	    boolean result = true;
	    while (null != slow || null != reverseHead) {
			if ((null == slow && null != reverseHead)||(null != slow && null == reverseHead) ||slow.val != reverseHead.val) {
				result = false;
				break;
			}
			slow  = slow.next;
			reverseHead = reverseHead.next;
		}
	     return result;
	    //
	}
	 
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		 }
}
