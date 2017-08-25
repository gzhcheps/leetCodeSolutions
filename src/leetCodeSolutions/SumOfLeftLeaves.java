package leetCodeSolutions;

import java.text.BreakIterator;

import org.junit.Test;

public class SumOfLeftLeaves {
	@Test
	public void main() {

	}

    public int sumOfLeftLeaves(TreeNode root) {
    	
    	
    	if (null == root ) {
			return  0;
		}else if (null == root.left && null != root.right) {
			return  sumOfLeftLeaves( root.right);
		}else if (root.left != null  && root.left.left ==null && root.left.right == null) {
			return root.left.val + sumOfLeftLeaves( root.right);
		}else {
			return sumOfLeftLeaves( root.left) + sumOfLeftLeaves( root.right);
		}
    	
        
    }
    
    
}
