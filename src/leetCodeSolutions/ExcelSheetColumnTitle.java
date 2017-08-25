package leetCodeSolutions;

import java.awt.HeadlessException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class ExcelSheetColumnTitle {
	int allCount = 4;
	@Test
	public void main() {
		System.out.println(titleToNumber("AB"));
	}
	
    public int titleToNumber(String s) {
        char[] data = s.toCharArray();
        int result = 0;
        for (int i = 0; i < data.length ; i++){
			result = result * 26 + data[i] - "A".toCharArray()[0] + 1;
		}
        return result;
     }
}
