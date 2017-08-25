package leetCodeSolutions;

import java.util.List;

import org.junit.Test;

public class LowestCommonAncestorOfABinarySearchTree {
	@Test
	public void main() {
		
	}

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root.val == q.val || root.val == p.val) {
			return root;
		}
    	
        if ((p.val <= root.val && root.val <= q.val)||(p.val >= root.val && root.val >= q.val)) {
			return root;
		}else if (p.val <= root.val && root.val >= q.val) {
			return lowestCommonAncestor( root.left,  p,  q);
		}else {
			return lowestCommonAncestor( root.right,  p,  q);
		}
    }

    public class TreeNode {
    	      int val;
    	      TreeNode left;
    	      TreeNode right;
    	      TreeNode(int x) { val = x; }
     }
}
