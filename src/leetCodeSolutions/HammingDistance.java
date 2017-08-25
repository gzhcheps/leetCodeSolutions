package leetCodeSolutions;

import org.junit.Test;

public class HammingDistance {
	@Test
	public void main() {

	}

	 public int hammingDistance(int x, int y) {
	        int xor = x ^ y;
	        int count = 0;
	        while (xor >0) {
	        	if (xor % 2 == 1) {
					count ++;
				}
	        	xor = xor >> 1;
			}
	        return count;
	 }
}
