package leetCodeSolutions;

import org.junit.Test;

public class CanPlaceFlowers {
	@Test
	public void main() {
		int[] test = new int[]{1,0,0,0,0,1};
		System.out.println(canPlaceFlowers(test,2));

	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int maxPlantCount = 0;
		int zeroArraylength = 0;
		boolean isStart = true;
		boolean isEnd = false;

		for (int i = 0; i < flowerbed.length ; i ++){
			if (flowerbed[i] == 1 || i == flowerbed.length -1){
				if (i == flowerbed.length -1 && flowerbed[i] == 0){
					zeroArraylength++;
					isEnd= true;
				}
				maxPlantCount += maxCountForZeroArray(zeroArraylength,isStart,isEnd);
				isStart = false;
				zeroArraylength = 0;
			}else {
				zeroArraylength ++;
			}
		}
		return maxPlantCount >= n;
	}

	private int maxCountForZeroArray(int arrayLength , boolean isStart , boolean isEnd){
		if (isStart && !isEnd || !isStart && isEnd){
			arrayLength ++;
		}else if (isStart && isEnd)
			return  (arrayLength+1)/2;
		if (arrayLength < 3){
			return  0;
		}else {
			return (arrayLength - 1)/2;
		}
	}
}
