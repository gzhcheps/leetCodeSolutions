package main.java.leetCodeSolutions;

import org.junit.Test;

public class MajorityElement {
	@Test
	public void main() {
		int[] test = {1,1,1,1,1,4,4,4,4};
		System.out.println(majorityElement(test));

	}

	public int majorityElement(int[] nums) {
		int maj = nums[0];
		int majCount = 1;
		for (int i =1 ;i < nums.length ; i ++){
			if (nums[i] != maj){
				if (majCount == 0){
					maj = nums[i];
					majCount = 1;
				}else {
					majCount --;
				}
			}else {
				majCount ++ ;
			}
		}
		return maj;
	}
}
