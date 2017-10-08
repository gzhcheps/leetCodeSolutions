package main.java.leetCodeSolutions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MinimunIndexSumOfTwoList {
	@Test
	public void main() {
		String[] l1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] l2 = {"KFC","Shogun","Burger King"};

		System.out.println(findRestaurant(l1,l2));
	}

    public String[] findRestaurant(String[] list1, String[] list2) {
		HashMap<Integer, List<String>> resultMap = new HashMap<>();
		int minIndex = list1.length + list2.length;

        for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if (list1[i].equals(list2[j])) {
					if (minIndex >= i + j){
						minIndex = i + j;
						if (null != resultMap.get(minIndex)){
							resultMap.get(minIndex).add(list1[i]);
						}else {
							List<String> list = new ArrayList<>();
							list.add(list1[i]);
							resultMap.put(minIndex,list);
						}
					}

				}
			}
		}

        String[] re = new String[resultMap.get(minIndex).size()];
        return resultMap.get(minIndex).toArray(re);
    }
    
    private class TreeComparator implements Comparable<TreeComparator>{
    	Integer listIndex;
    	Integer minIndex;
    	
    	 TreeComparator(int list,int index){
    		 this.listIndex = list;
    		 this.minIndex = index;
    	 }

		@Override
		public int compareTo(TreeComparator o) {
			if (this.minIndex == o.minIndex) {
				return this.listIndex - o.listIndex;
			}else {
				return this.minIndex - o.minIndex;
			}
		}
    }
}
