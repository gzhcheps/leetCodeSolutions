package leetCodeSolutions;

import java.text.BreakIterator;

import org.junit.Test;

public class LinkedListCycle {
	@Test
	public void main() {

	}

	 public boolean hasCycle(ListNode head) {
	       ListNode slow = head;
	       ListNode quick = head;
	       boolean hasCycle = false;
	       while (null != quick && null != quick.next) {
	    	   	slow = slow.next;
	    	   	quick = quick.next.next;
	    	   	if (null != quick && quick.val == slow.val) {
					hasCycle = true;
					break;
				}
		   }
	       return hasCycle;
	 }

	 
	 class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		         val = x;
		          next = null;
		      }
	}
}
