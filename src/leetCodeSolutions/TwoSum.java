package leetCodeSolutions;

import org.junit.Test;

public class TwoSum {
	@Test
	public void main(){
		
	}
	/**
	 * 考虑0和负数
	 * @param nums
	 * @param target
	 * @return
	 */
	private int[] getSumIndex(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			result[0] = i;
			for (int j = i + 1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target){
					result[1] = j;
					return result;
				}
			}
		}
		return result;
		
	}
}
