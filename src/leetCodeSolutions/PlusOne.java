package leetCodeSolutions;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

public class PlusOne {
	@Test
	public void main() {
		int[] test = new int[] {0};
		int[] Result = plusOne(test);
	}

    public int[] plusOne(int[] digits) {
        List<Integer> resultList = new ArrayList<>();
        int addDigit = 1;
        for (int i = digits.length -1 ; i >=0; i --) {
        	
			resultList.add((digits[i]  + addDigit)%10);
			addDigit = (digits[i] + addDigit)/10;
		}
        if (addDigit > 0) {
        	resultList.add(1);
		}
        
        int[] result = new int[resultList.size()];
        for (int i = resultList.size() -1 ; i >=0; i--) {
        	result[resultList.size() -1 - i] = resultList.get(i);
		}
        return result;
    }
}
