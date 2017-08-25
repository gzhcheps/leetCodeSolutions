package leetCodeSolutions;

import org.junit.Test;

public class ReverseInteger {
	@Test
	public void main() {

	}

	public int reverse(int x) {
		boolean isMinux = x > 0 ? false : true;
		int dst = 0;
		int xAbs = Math.abs(x);
		
		while (xAbs != 0) {
			if (dst > (Integer.MAX_VALUE - xAbs % 10)/10) {
				return 0;
			}
			dst *= 10;
			dst += xAbs % 10 ;
			xAbs =( xAbs - xAbs % 10) /10;
			
		}
		
		if (isMinux) {
			return (0 - dst);
		}else {
			return dst;
		}
		
	}
}
