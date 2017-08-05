package Euler;

import java.math.BigInteger;

/*
 * 问题:求100！的各个数位的和
 * 方案:100！的阶乘数字极大,可以采用用数组模拟乘法进行计算
 * 
 * 自己的方案:
 * 	时间:4hours
 * 	效率:240ms
 * 系统的方案:
 * 	时间:10mins
 * 	效率:26ms
 * 
 * 事实证明,调用系统函数比自己重写效率高很多
 */

public class FactorialDigitSum {
	public static void main(String[] args) {
		double time = System.currentTimeMillis();
		
		
//		BigInteger number = BigInteger.ONE;
//		for(int i = 1; i<=100 ; i++){
//			number = number.multiply(new BigInteger(i+""));
//		}
//		String s = number.toString();
//		int [] n = new int[s.length()];
//		int sum = 0;
//		for(int i = 0; i<n.length ; i++){
//			n[i] = Integer.parseInt(s.substring(i,i+1));
//			System.out.print(n[i]);
//			sum+=Integer.parseInt(s.substring(i,i+1)) ;
//		}
//		System.out.println();
//		System.out.println(sum);
		
		
		int[] number = {1};
		for(int i = 1 ; i<=100 ; i++){
			number = multiply(number , getIntArray(i));
		}
		int digitSum = 0;
		for(int x : number){
			System.out.print(x);
			digitSum+=x;
		}
		System.out.println();
		System.out.println(digitSum);
		
		System.out.println("程序运行时间:"+(System.currentTimeMillis()-time)+"ms");
	}
	
	
	//用数组实现乘法
	private static int[] multiply(int[] multiplier , int[] multiplicand){
		//判断结果的位数
		int length = getProductDigit(multiplier, multiplicand);
		int[] answer = new int[length];
		int CF = 0;//进位符号
		for(int digit = 0; digit < length ; digit++){
				for(int i = digit ; i>=0 ; i--){
					if(isLegal(multiplier, multiplier.length-1-i) && isLegal(multiplicand, multiplicand.length-1-digit+i)){
						answer[length-1-digit] += multiplier[multiplier.length-1-i]*multiplicand[multiplicand.length-1-digit+i];
					}else{
						continue;
					}
				}
				if((answer[length-1-digit]+=CF)>=10){
					CF = answer[length-1-digit]/10;
					answer[length-1-digit]%=10;
				}else{
					CF=0;
				}
		}
		return answer;
	}
	//获取由int数字各位数字构成的数组
	private static int[] getIntArray(int number){
		final int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999,    
	            99999999, 999999999, Integer.MAX_VALUE };
		int digit = 0;
		while(true){
	        if (number <= sizeTable[digit])
	        	break;
	        digit++;
		}
		int[]answer =new int[digit+1];
		for(int i = 0; i<answer.length ; i++){
			answer[answer.length-1-i] = number%10;
			number/=10;
		}
		return answer;
	}
	//判断所用数组和角标是否合法
	private static boolean isLegal(int[] number, int index){
		return index>=0 && index<number.length;
	}
	//返回传入参数的乘积的位数
	private static int getProductDigit(int[] multiplier,int[] multiplicand){
		String a = "";
		String b = "";
		for(int x : multiplier){
			a+=x;
		}
		for(int x : multiplicand){
			b+=x;
		}
		return new BigInteger(a).multiply(new BigInteger(b)).toString().length();
		
		
	}
}
