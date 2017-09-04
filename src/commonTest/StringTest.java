package commonTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import leetCodeSolutions.LowestCommonAncestorOfABinarySearchTree.TreeNode;

public class StringTest {
	@Test
	public void main() {
		System.out.println(String.format("你说啥%s%s","就是屌屌屌","厉害啊"));
		
		System.out.println("aaa!！就是牛逼".toCharArray().length);getClass();
		char[] array = "aaa!！就是牛逼".toCharArray();
		System.out.println("diao");
		
		
		
		Integer aInteger = null;
		String aString = aInteger + "";
		System.out.println(aString);
		
		
		
		Long a= 100185l;
		Integer b = 100185;
		System.out.println(a.intValue() == b);
		
		
		
		Integer testInt = new Integer(3);
		
		Integer testInt2 = new Integer(3);
		
		System.out.println(testInt == testInt2);
		System.out.println(testInt.equals(testInt2));
	}

    

   
}
