package leetCodeSolutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class NumberOfBoomerangs {
	@Test
	public void main() {
		int[][] test= {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
		System.out.println(numberOfBoomerangs(test));
	}

    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        List<Map<Integer, Integer>> resultMap = new ArrayList<Map<Integer, Integer>>();
        for (int i = 0; i < points.length; i++) {
        	Map<Integer, Integer> singleMap = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				int xDis =  (points[i][0] - points[j][0])*(points[i][0] - points[j][0]) + (points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
				if (null == singleMap.get(xDis)) {
					singleMap.put(xDis, 1);
				}else {
					singleMap.put(xDis, singleMap.get(xDis) + 1);
					
				}
			}
			resultMap.add(singleMap);
		}
        for (Map<Integer, Integer> key : resultMap) {
        	//count += aMethod(resultMap.get(key))/2;
        	for (int singleKey : key.keySet()) {
				count += aMethod(key.get(singleKey),2);
				
			}
		}
        
        return count;
    }
    
    private int aMethod(int num ,int sort){
    	if (num < 2) {
			return 0;
		}
    	return ladderMulti(num) / ladderMulti(num - sort);
    }
    
    private int ladderMulti(int num ){
    	if (num <= 1){
    		return 1;
		}else {
			return num*ladderMulti(-- num);
		}
    }
}
