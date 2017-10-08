package leetCodeSolutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ImplementStackUsingQueues {
	@Test
	public void main() {
		int[] test = new int[]{1,0,0,0,0,1};
		System.out.println(canPlaceFlowers(test,2));

	}

	class MyStack {

		List<Integer> list;

		/** Initialize your data structure here. */
		public MyStack() {
			list = new ArrayList<>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			list.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			int result = list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return result;
		}

		/** Get the top element. */
		public int top() {
			return list.get(list.size() - 1);
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return  list.isEmpty();
		}
	}
}
