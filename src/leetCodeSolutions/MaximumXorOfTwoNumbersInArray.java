package leetCodeSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

public class MaximumXorOfTwoNumbersInArray {
	@Test
	public void main(){
		int[] input = {10,23,20,18,28};
		System.out.println(findMaximumXOR(input));
	}
	
	
    public int findMaximumXOR(int[] nums) {
		Map<Integer, List<Integer>> cacheNums = new HashMap<>();
		int highest = 0;
		for (int i = 0; i < nums.length; i++) {
			int count  = countHighestNum(nums[i]);
			if (highest <= count) {
				highest = count;
				if (cacheNums.get(count) == null) {
					cacheNums.put(count, new ArrayList<Integer>());
				}
				cacheNums.get(count).add(nums[i]);
			}
		}
		
	
		
        int maxResult = 0;
        List<Integer> highestNums = cacheNums.get(highest);
        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j < highestNums.size(); j++) {
				if (maxResult < (nums[i]^highestNums.get(j))) {
					maxResult = nums[i]^highestNums.get(j);
				}
			}
		}
        
        return maxResult;
    }
	
	
	private int countHighestNum(int num) {
		int count = 0;
		if (num == 0) {
			return 1;
		}
		while (num>0) {
			count ++;
			num = num >>1;
			
		}
		return count;
	}
}
