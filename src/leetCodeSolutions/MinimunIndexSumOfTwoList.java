package leetCodeSolutions;

import java.util.Comparator;
import java.util.TreeMap;

import org.junit.Test;

public class MinimunIndexSumOfTwoList {
	@Test
	public void main() {
		String[] l1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] l2 = {"KFC","Burger King","Tapioca Express","Shogun"};
		System.out.println(findRestaurant(l1,l2));
	}

    public String[] findRestaurant(String[] list1, String[] list2) {
        TreeMap<TreeComparator, String> resultMap = new TreeMap<>(new Comparator<TreeComparator>() {

			@Override
			public int compare(TreeComparator o1, TreeComparator o2) {
				if (o1.minIndex == o2.minIndex) {
					return o1.listIndex - o2.listIndex;
				}else {
					return o1.minIndex - o2.minIndex;
				}
			}
		});
        for (int i = 0; i < list1.length; i++) {
			for (int j = 0; j < list2.length; j++) {
				if (list1[i].equals(list2[j])) {
					TreeComparator tComparator = new TreeComparator(i + j,j);
					resultMap.put(tComparator, list1[i]);
				}
			}
		}
        String[] re = new String[resultMap.values().size()];
        return resultMap.values().toArray(re);
    }
    
    private class TreeComparator implements Comparable<TreeComparator>{
    	Integer listIndex;
    	Integer minIndex;
    	
    	 TreeComparator(int index,int list){
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
