package leetCodeSolutions;

import java.awt.HeadlessException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageTypeSpecifier;

import org.junit.Test;

public class AssignCookies {
	int allCount = 4;
	@Test
	public void main() {
		int[] test = {1,23,5,6,3,2124,324,34,5,656,776,7,8,4,4345,45,99};
		quickSort(test,0,test.length -1);
		
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
		
	}
	
    public int findContentChildren(int[] g, int[] s) {
    	if (null == g  || null == s || g.length == 0 || s.length ==0) {
			return 0;
		}
        int fitCount = 0;
        quickSort(g,0,g.length -1);
        quickSort(s,0,s.length -1);
        
        int gs = 0;
        int ss = 0;
        
        while (gs < g.length && ss < s.length) {
			if (s[ss] >= g[gs]) {
				fitCount ++;
				ss ++;
				gs ++;
			}else {
				ss ++;
			}
			
		}
        return fitCount;
    }
    
    private void quickSort(int[] num,int start ,int end){
    	if (end - start < 1) {
			return;
		}
    	
    	if (end - start == 1) {
			if (num[start] < num[end]) {
				return;
			}else {
				int tmp = num[end];
				num[end] = num[start];
				num[start] = tmp;
				return;
			}
		}
    	
    	int sp = start;
    	int ep = end;
    	int mark = sp;
    	while (sp < ep) {
			while (num[ep] > num[mark]) {
				ep --;
			}
			
			if (sp < ep) {
				int tmp = num[ep];
				num[ep] = num[mark];
				num[mark] = tmp;
				mark = ep;
				sp ++ ;
			}
			
			if (sp >= ep) {
				break;
			}
			
			while (num[sp] < num[mark]) {
				sp ++ ;
			}
			
			if (sp < ep) {
				int tmp = num[sp];
				num[sp] = num[mark];
				num[mark] = tmp;
				mark = sp;
				ep -- ;
			}
		}
    	
    	quickSort(num,start,mark -1);
    	quickSort(num,mark + 1,end);
    }
}
