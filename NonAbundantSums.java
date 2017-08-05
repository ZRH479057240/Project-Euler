package Euler;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 问题:求所有不可成为两个非丰富数的和的数字总和。
 * 	丰富数:约数和大于本身的数
 * 	定理:大于28123的数字必定可以表示为两个丰富数之和
 * 方案1:获取非丰富数列表,对每一个数字进行判断再求和 //消耗时间:2522675.0
 * 方案2:获取所有范围内丰富数的和,将剩余数字求和//消耗时间:9756.0
 */


public class NonAbundantSums {
	public static void main(String[] args) {
		double time = System.currentTimeMillis();
		
		int sum = 0;

		ArrayList<Integer> abundantNumber = new ArrayList<>();//10146.0
		HashSet<Integer> numberList = new HashSet<>();
//		LinkedList<Integer> abundantNumber = new LinkedList<>();//13823.0
		
		for(int i = 1; i<28123 ; i++){
			if(i<getFactorSum(i)){
				abundantNumber.add(i);
			}
		}
		
		
		//方案1
//		for(int i = 1; i<28123 ; i++){
//			sum+=i;
//		}		
//		System.out.println(sum);
//		for(int number = 1; number<28123 ; number++){
//			System.out.println(number);
//			for(Integer x : abundantNumber){
//				if(x>number)
//					break;
//				if(abundantNumber.contains(number-x));
//				sum-=number;
//			}
//		}
		
		//方案2
		for(int i = 0; i<abundantNumber.size() ;i++){
			for(int j = 0; j<abundantNumber.size() ;j++){
				if(abundantNumber.get(i)+abundantNumber.get(j)<28123){
					numberList.add(abundantNumber.get(i)+abundantNumber.get(j));
				}
			}
		}
		for(int i = 0;i<28123; i++){
			if(!numberList.contains(i))
				sum+=i;
		}
		System.out.println(sum);
		
		
		
		System.out.println(System.currentTimeMillis()-time);
	}
	private static int getFactorSum(int number){
		int result = 0;
		for(int i=1; i<number ;i++){
			if(number%i==0)
				result+=i;
		}
		return result;
	}
}
