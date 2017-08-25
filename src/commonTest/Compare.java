package commonTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import leetCodeSolutions.LowestCommonAncestorOfABinarySearchTree.TreeNode;

public class Compare {
	@Test
	public void main() {
		List<Bean> beans = new ArrayList<>();
		beans.add(new Bean(0, "abaaaaaaaaaa"));
		beans.add(new Bean(0, "aba"));
		beans.add(new Bean(0, "abaa"));
		beans.add(new Bean(0, "z"));
		beans.add(new Bean(0, "abc"));
		beans.add(new Bean(1, null));
		beans.add(new Bean(1, null));
		beans.add(new Bean(0, "fff"));
		beans.add(new Bean(0, "d"));
		beans.add(new Bean(0, "lllllaa"));
		beans.add(new Bean(0, "aa"));
		beans.add(new Bean(1, "aa"));
		beans.add(new Bean(0, "a"));
		
		Collections.sort(beans, new Comparator<Bean>() {
			@Override
			public int compare(Bean h1, Bean h2) {
				if (h1.status != h2.status) {
					return -(h1.status - h2.status);
				}
				if (null == h1.name && null != h2.name) {
					return 1;
				}else if (null != h1.name && null == h2.name) {
					return -1;
				}else if (null == h1.name && null == h2.name) {
					return 0 ;
				}else {
					return h1.name.compareToIgnoreCase(h2.name);
				}
			}
			});
		
		for (int i = 0; i < beans.size(); i++) {
			System.out.println(beans.get(i).toOutPutString());
		}
		
		
		
	}

    

    public class Bean {
    	int status;
    	String name;
    	public Bean(int status, String name) {
			this.status = status;
			this.name  = name;
		}
    	
    	public String toOutPutString() {
			return status + "-" + name;
		}
     }
}
