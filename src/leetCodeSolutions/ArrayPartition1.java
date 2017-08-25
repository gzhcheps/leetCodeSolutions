package leetCodeSolutions;

import org.junit.Test;

public class ArrayPartition1 {
	@Test
	public void main() {
		int[] nums = {0,3,2,6,6,3};
		System.out.println(arrayPairSum(nums));
	}

    public int arrayPairSum(int[] nums) {
        nums = quickSort(nums, 0, nums.length -1);
        int result = 0;
        for (int i = 0; i < nums.length; i +=2) {
        	result += nums[i];
		}
        return result;
    }
    
    private int[] quickSort(int[] src,int startIndex,int endIndex){
    	int mark = startIndex;
    	int start = src[mark];
    	
    	int startTmp = startIndex;
    	int endTmp = endIndex;
    	while (startTmp < endTmp ) {
    		while (src[endTmp] > start) {
    			endTmp --;
			}
    		if (startTmp >= endTmp) {
				break;
			}
    		int tmp = src[startTmp];
    		src[startTmp] = src[endTmp];
    		src[endTmp] = tmp;
    		startTmp ++;
    		mark = endTmp;
    		while (src[startTmp] < start) {
    			startTmp ++;
			}
    		if (startTmp >= endTmp) {
				break;
			}
    		int tmp1 = src[startTmp];
    		src[startTmp] = src[endTmp];
    		src[endTmp] = tmp1;
    		endTmp --;
    		mark = startTmp;
		}
    	if (mark > startIndex+1) {
    		src = quickSort(src, startIndex, mark-1);
		}
    	if (mark+1 < endIndex) {
    		src = quickSort(src, mark+1, endIndex);
		}
    	return src;
    }
}
