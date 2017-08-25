package leetCodeSolutions;

import org.junit.Test;

public class AddStrings {
	@Test
	public void main() {
		String st1 = "9";
		String st2 = "99";
		System.out.println(addStrings(st1,st2));
	}

    public String addStrings(String num1, String num2) {
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        
        char[] result = new char[num1Char.length > num2Char.length ? num1Char.length + 1 : num2Char.length + 1];
        
        char[] numMap = "0123456789".toCharArray();
        int improve = 0;
        
        int index1 = num1Char.length -1;
        int index2 = num2Char.length -1;
        int indexR = result.length -1;
        while (index1 >= 0 || index2 >= 0) {
        	
        	int sum = Integer.valueOf(index1 < 0 ? "0" :String.valueOf(num1Char[index1])) + Integer.valueOf(index2 < 0 ? "0" :String.valueOf(num2Char[index2])) + improve;
        	improve = sum /10;
        	result[indexR] = numMap[sum%10];
        	indexR --;
        	if (index1 <=0 && index2 <=0) {
				break;
			}
        	if (index1 >= 0) {
        		index1 --;
			}
        	if (index2 >= 0) {
        		index2 --;
			}
        	
        	
        	
        	
		}
        if (improve > 0) {
        	 result[indexR] = numMap[improve];
		}
       
        return String.valueOf(result).trim();
    }
}
