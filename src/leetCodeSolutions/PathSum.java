package leetCodeSolutions;

import org.junit.Test;

public class PathSum {
	@Test
	public void main() {
		
	}
	
	 public boolean hasPathSum(TreeNode root, int sum) {
	        if (null == root) {
				return false;
			}
		
			return hasPathSumPart(root, 0 ,sum);
		 
	 }
	 
	 private boolean hasPathSumPart(TreeNode node, int sum ,int goal) {
		 if (null == node) {
			return false;
		}
	        if (null == node.left && null == node.right && (node.val + sum == goal)) {
				return true;
			}else {
				 return hasPathSumPart(node.left,sum +node.val,goal) || hasPathSumPart(node.right,sum +node.val,goal) ;
			}
	 }
}
