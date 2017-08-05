package Euler;

/*
 * 问题:求10000以内所有的亲和数。
 * 	亲和数:即互为因数和的一对数字。
 * 方案:求每一个数字的因数和并验证其因数和是否等于原数字。
 * 
 */


public class AmicableNumbers {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=10000 ;i++){
			if(i == getFactorSum(getFactorSum(i)) && i!=getFactorSum(i)){
				System.out.println(i+"-->"+getFactorSum(i));
				sum+=i;
			}
		}
		System.out.println(sum);
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
