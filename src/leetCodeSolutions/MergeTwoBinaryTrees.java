package leetCodeSolutions;

import org.junit.Test;

public class MergeTwoBinaryTrees {
	@Test
	public void main() {

	}

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (null == t1 && null == t2) {
			return null;
		}
		TreeNode treeNode = new TreeNode((null == t1 ? 0 : t1.val) + (null == t2 ? 0 : t2.val));
		if ((null != t1 && null != t1.left) || (null != t2 && null != t2.left)) {
			treeNode.left = mergeTrees((null == t1 ? null : t1.left), (null == t2 ? null : t2.left));
		}
		if ((null != t1 && null != t1.right) || (null != t2 && null != t2.right)) {
			treeNode.right = mergeTrees((null == t1 ? null : t1.right), (null == t2 ? null : t2.right));
		}
		return treeNode;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
