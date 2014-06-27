import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

public class Solutions {
	@Test
	public void main() {
/*		String ssString = reverseWords("sss");
		

		int[] A = {2,2,3,2};
		int result = singleNumber2(A);*/
/*		String teString = "catsanddog";
		Set<String> testSet = new HashSet<>();
		testSet.add("cat");
		testSet.add("cats");
		testSet.add("and");
		testSet.add("sand");
		testSet.add("dog");*/
/*		String teString = "aaaaaaa";
		Set<String> testSet = new HashSet<>();
		testSet.add("aaaa");
		testSet.add("aa");
		testSet.add("a");
		List<String> resultString = wordBreak2(teString, testSet);*/
		String gaString = "1,2,3,3";
		String[] gas = gaString.split(",");
		String[] cost = "2,1,5,1".split(",");
		int[] gasInt = new int[gas.length];
		for (int i = 0; i < gas.length; i++) {
			gasInt[i] = Integer.parseInt(gas[i]); 
		}
		int[] costInt = new int[cost.length];
		for (int i = 0; i < cost.length; i++) {
			costInt[i] = Integer.parseInt(cost[i]); 
		}
		int result = canCompleteCircuit(gasInt,costInt);
	}
	/**There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
	 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
	 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
	 * Note:
	 * The solution is guaranteed to be unique.*/
	public int canCompleteCircuit(int[] gas, int[] cost) {
		   if(gas.length<2 && cost[0]>gas[0]){
	            return -1;
	        }
	        int[] pureGas = new int[gas.length];
			int total = 0;
			for (int i = 0; i < gas.length; i++) {
				pureGas[i] = gas[i] - cost[i];
				total += pureGas[i];
			}
			if (total<0) {
				return -1;
			}else {
				int resultIndex = 0;
				int sum = 0;
				int maxSum = 0;
				for (int i = 0; i < pureGas.length; i++) {
					sum += pureGas[i];
					if (sum > maxSum) {
						maxSum = sum;
					}else if (sum < 0) {
						sum = 0;
						resultIndex = i;
					}
				}
				
				return (resultIndex+1)%pureGas.length;
			}
		
	}
	/**There are N children standing in a line. Each child is assigned a rating value.
	 * You are giving candies to these children subjected to the following requirements:
	 * Each child must have at least one candy.
	 * Children with a higher rating get more candies than their neighbors.
	 * What is the minimum candies you must give?*/
	 public int candy(int[] ratings) {
		 int[] result = new int[ratings.length];
		 result[0] = 1;
		 for (int i = 1; i < ratings.length; i++) {
			if (ratings[i]>ratings[i-1]) {
				result[i] = result[i-1]+1;
			}else if (result[i] == 0) {
				result[i] = 1;
			}
		}
		 for (int i = ratings.length-2; i >=0; i--) {
			if (ratings[i]>ratings[i+1]&&result[i] <= result[i+1]) {
				result[i] = result[i+1]+1;
			}
		}
		 int sum = 0;
		 for (int i = 0; i < result.length; i++) {
			sum += result[i];
		}
		 return sum;
	 }
	
	/**Implement int sqrt(int x).
	 * Compute and return the square root of x.*/
	public int sqrt(int x) {
		int digits[] = new int[5];
		int digitNum = 0;
		int a = x;
		while (a > 0) {
			digits[digitNum] = a % 100;
			a /= 100;
			digitNum++;
		}
		int result = 0;
		int nowDigit = 0;
		for (int i = digitNum - 1; i >= 0; i--) {
			nowDigit *= 100;
			nowDigit += digits[i];
			result *= 10;
			int eachTry = result*2;
			int eachTest = 0;
			for (int j = 0; j < 10; j++) {			
				if ((eachTry + j) * j <= nowDigit) {
					eachTest = j;
				}else {
					break;
				}				
			}
			result += eachTest;
			nowDigit = nowDigit -( eachTry + eachTest)* eachTest;
		}
		return result;
	}
	/**Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
	 *Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	 *Note:
	 *You are not suppose to use the library's sort function for this problem.*/
	 public void sortColors(int[] A) {
	      int zeros = 0;
	      int ones = 0;
	      for (int i = 0; i < A.length; i++) {
			if (A[i]==0) {
				zeros ++;
			}else if (A[i]==1) {
				ones ++;
			}
		}
	      for (int i = 0; i < A.length; i++) {
			if (i<zeros) {
				A[i] = 0;
			}else if (i<zeros+ones) {
				A[i] = 1;
			}else {
				A[i] = 2;
			}
		}
	 }
	 /**Given a non-negative number represented as an array of digits, plus one to the number.
	  * The digits are stored such that the most significant digit is at the head of the list.*/
	 public int[] plusOne(int[] digits) {
		    for (int i = digits.length-1; i >= 0; i--) {
				if (digits[i] <9) {
					digits[i] ++;
					break;
				}else {
					digits[i] = 0;
					int length = digits.length+1;
					if(i==0){
					    int results[] = new int[length];
					    results[0] = 1;
					    for (int j = 1; j < results.length; j++) {
					    	results[j] = digits[j-1];
						}
					    return results;
					}
				}
			}
			 return digits;
	 }
	/**
	 * You are climbing a stair case. It takes n steps to reach to the top.
	 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
 	public int climbStairs(int n) {
 		//每步的来源都是之前的走法走一步或者两步两种可能，f(n)=f(n-1)+f(n-2)
 		//此为斐波那契数列.为了保证效率,用空间换时间
		int result =0;
		if (n<3) {
			result = n;
		}else {
		    int results[] = new int[n];
		    results[0] = 1;
 	     	results[1] = 2;
			for (int i = 2; i < n; i++) {
				results[i] = results[i-1]+results[i-2];
			}
			result = results[n-1];
		}
		return result;
	}
	
	/**
	 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
	 * Return all such possible sentences.
	 * For example, given
	 * s = "catsanddog",
	 * dict = ["cat", "cats", "and", "sand", "dog"].
	 * A solution is ["cats and dog", "cat sand dog"].*/
	public List<String> wordBreak2(String s, Set<String> dict) {
		List<String> resultList = new ArrayList<>();
		boolean result = false;
		//先做一遍校验，查看是否s中所有的字母都在dict集合中出现
		for (int i = 0; i < s.length(); i++) {
			String singleCharString =  String.valueOf(s.charAt(i));
			Iterator<String> iterator = dict.iterator();
			result = false;
			//对某个字母，若在整个dict集合中都没有，则直接判定无法解析字符串
			while (iterator.hasNext()) {
				if (iterator.next().contains(singleCharString)) {
					result = true;
				}
			}
			if (!result) {
				break;
			}
		}
		//若通过逐个字母的校验，再进行组合判断
		if (result) {
			resultList = wordBreakEach2(s, dict,"",resultList);
		}		
	    return resultList;
	}
	public List<String> wordBreakEach2(String s, Set<String> dict,String lastResult,List<String> resultList) {
	    for (int i = 1; i <s.length()+1 ; i++) {
			String sub = s.substring(0,i);
			if (dict.contains(sub)) {
				//记录匹配的字符串
				if (!lastResult.isEmpty()) {
					lastResult += " ";
				}
				lastResult +=sub;
				if (s.length() - sub.length() == 0) {	
					//当完全匹配时，添加到集合中
					resultList.add(lastResult);
					break;
				}else {
					//不完全匹配时则进行下一次判断
					resultList = wordBreakEach2(s.substring(i,s.length()), dict,lastResult,resultList);					
				}
				//对下一次迭代产生返回的结果，无论是否匹配成功，都把目前匹配的字符串进行一次回退，然后进入下一个循环
				/*例如目标字符串aaaa，集合为{aaa,aaaa}
				 *进行判断时，与aaa即可匹配，然后针对a进行判断，此时记录的匹配字符串即为aaa
				 *a判断是不匹配的，回退到对aaaa的判断，应清除匹配aaa的影响，重新匹配aaaa，
				 *故将记录字符串回退，再循环*/
				lastResult = lastResult.substring(0,lastResult.length()-sub.length()).trim();
				
			}
		}   
	    return resultList;
	}
	/**
	 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	 * For example, given
	 * s = "leetcode",
	 * dict = ["leet", "code"].
	 * Return true because "leetcode" can be segmented as "leet code".*/
	public boolean wordBreak(String s, Set<String> dict) {
		boolean result = false;
		//先做一遍校验，查看是否s中所有的字母都在dict集合中出现
		for (int i = 0; i < s.length(); i++) {
			String singleCharString =  String.valueOf(s.charAt(i));
			Iterator<String> iterator = dict.iterator();
			result = false;
			//对某个字母，若在整个dict集合中都没有，则直接判定无法解析字符串
			while (iterator.hasNext()) {
				if (iterator.next().contains(singleCharString)) {
					result = true;
				}
			}
			if (!result) {
				break;
			}
		}
		//若通过逐个字母的校验，再进行组合判断
		if (result) {
			result = false;
			result = wordBreakEach(s, dict);
		}		
	    return result;
	}
	public boolean wordBreakEach(String s, Set<String> dict) {
		boolean result = false;
	    for (int i = 1; i <s.length()+1 ; i++) {
			String sub = s.substring(0,i);
			if (dict.contains(sub)) {
				if (s.length() - sub.length() == 0) {
					result = true;
					break;
				}else {
					result = wordBreak(s.substring(i,s.length()), dict);
					if (result) {
						break;
					}
				}
			}
		}   
	    return result;
	}
	/**Given an array of integers, every element appears three times except for one. Find that single one.
	 * Note:
	 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
    public int singleNumber2(int[] A) {
        int goal = 0;
        HashMap<Integer, Integer> resultHashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
        	int nowNum = A[i];
			if (resultHashMap.get(nowNum) == null) {
				resultHashMap.put(nowNum, 2);
			}else {
				int count = resultHashMap.get(nowNum);
				count --;
				resultHashMap.put(nowNum, count);
				if (count == 0) {
					resultHashMap.remove(nowNum);
				}
			}
		}
        Set<Integer> result = resultHashMap.keySet();
        Iterator<Integer> iterator = result.iterator();
		goal = iterator.next();
        return goal;
    }
    /**To solve this problem using only constant space, you have to rethink how the numbers are being represented in computers -- using bits.
     * If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due to the constraint of this problem where each number must appear either three times or once. This will be the ith bit of that "single number".
     * A straightforward implementation is to use an array of size 32 to keep track of the total count of ith bit.
     * 思路为二进制逐位看，在某位上所有数相加模3后，只保留了重复一次数字的信息，其他数字因为重复3次而被清零
     * 那么再逐位将这样的结果拼凑成一个数字，所得即为所求*/
    int singleNumberBetter(int A[], int n) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                if (((A[j] >> i) & 1)!=0) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
	/**Given an array of integers, every element appears twice except for one. Find that single one.
	 * Note:
	 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/
	   public int singleNumber(int[] A) {
		   int candidate = 0;
	        for (int i = 0; i < A.length; i++) {
	        	//累计异或，有相同的值则互相抵消
				candidate ^= A[i];
			}
	        return candidate;
	    }
	  /**test data
	   * Point point1 = new Point(1, 2);
		Point point2 = new Point(2, 3);
		Point[] points ={new Point(2,3),new Point(3,3),new Point(-5,3)};{new Point(40,-23),new Point(40,-23),new Point(40,-23),new Point(40,-23),
			new Point(41,-20),new Point(41,-40),
			new Point(40,-23),new Point(40,-23),new Point(41,-60),
			new Point(45,-18),new Point(50,-13),new Point(55,-8),new Point(60,-3),new Point(65,2)
		};
		{new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)};
		{new Point(3, 4),new Point(3, 4),new Point(3, 4)};
		,point1, point2,new Point(3, 4),new Point(4, 5),new Point(5,1)};
		*/
	/**
	 * Definition for a point. 
	 * */
	class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	  }
	/**Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.*/
	public int maxPoints(Point[] points) {
		int maxNum = 0;
		// 应对空集与少于3点的情况
		if (points.length < 3) {
			maxNum = points.length;
		} else {
			for (int i = 0; i < points.length - 1; i++) {
				Point firstPoint = points[i];
				int num = 0;
				for (int j = i + 1; j < points.length; j++) {
					num = 2;
					Point secondpPoint = points[j];
					Point lineParamPoint = new Point();
					// 对于互不相同的三点，若点1点2的连线斜率与点1点3的连线斜率相同，则3点在同一直线上
					lineParamPoint.x = secondpPoint.x - firstPoint.x;// a
					lineParamPoint.y = secondpPoint.y - firstPoint.y;// b
					//若第二点不与第一点重合，进行第三点扫描判断
					if (!(lineParamPoint.x==0&&lineParamPoint.y ==0)) {
						for (int k = j + 1; k < points.length; k++) {
							Point thirdPoint = points[k];
							if (lineParamPoint.x == 0) {
								if (secondpPoint.x == thirdPoint.x) {
									num++;
								}
							} else if (lineParamPoint.y == 0) {
								if (secondpPoint.y == thirdPoint.y) {
									num++;
								}
							} else {
								if ((thirdPoint.x - firstPoint.x)
										* lineParamPoint.y == (thirdPoint.y - firstPoint.y)
										* lineParamPoint.x) {
									num++;
								}

							}						
						}

					}
					//第二点之后的重复点也已经扫描收录。补查第二点之前的重复点
					for (int k = 0; k < j; k++) {
						Point thirdPoint = points[k];
						if (k != i
							&& ((thirdPoint.x == firstPoint.x && thirdPoint.y == firstPoint.y) ||
									(thirdPoint.x == secondpPoint.x && thirdPoint.y == secondpPoint.y))) {
							num++;
						}

					}
					if (num > maxNum) {
						maxNum = num;
					}

				}

			}
		}

		return maxNum;

	    }
	/**
	 * Given an input string, reverse the string word by word. For example,
	 * Given s = "the sky is blue", return "blue is sky the".
	 */
	public String reverseWords(String s) {
		String result = "";
		s = s.trim();
		String[] results = s.split(" ");
		for (int i = results.length - 1; i >= 0; i--) {
			//当遇到多个空格时，防止将空格也作为单词进行操作
			if (!results[i].equals("")) {
				result += results[i];
				if (i != 0) {
					result += " ";
				}
			}
		}
		return result;
	}
	
	/**Evaluate the value of an arithmetic expression in Reverse Polish Notation.
	 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
	 * Some examples:
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/
	public int evalRPN(String[] tokens) {
		Stack<Integer> inputNums = new Stack<>();
		/**逆波兰表达式就是将操作数入栈，当判断到操作符时出栈进行计算
		 * 计算结果再入栈，如此循环最后栈顶元素即为结果*/
		for (int i = 0; i < tokens.length; i++) {

			String singleString = tokens[i];
			if (!"+-*/".contains(singleString)) {
				int a = Integer.parseInt(singleString);
				inputNums.push(a);
			} else {
				int second = inputNums.pop();
				int first = inputNums.pop();
				int result = 0;
				switch (singleString) {
				case "+":
					result = first + second;
					break;
				case "-":
					result = first - second;
					break;
				case "*":
					result = first * second;
					break;
				case "/":
					result = first / second;
					break;
				default:
					break;
				}
				inputNums.push(result);
			}
		}
		return inputNums.pop();
	}
}
