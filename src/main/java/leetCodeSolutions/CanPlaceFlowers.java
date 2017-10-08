package leetCodeSolutions;

import org.junit.Test;

public class TwoSumII {
	@Test
	public void main() {
		int[] test = new int[]{2, 7, 11, 15};
		System.out.println(twoSum(test,9));

	}

	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[]{0,0};
		for (int i = 0;i<numbers.length;i++){

			if (result[0] > 0)
				break;
			for (int j = i + 1; j < numbers.length;j++){

				if (numbers[i] + numbers[j] == target){
					result[0] = i +1;
					result[1] = j +1;
					break;
				}
			}
		}
		return result;
	}
}
