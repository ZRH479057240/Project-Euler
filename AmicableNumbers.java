package Euler;

/*
 * ����:��10000�������е��׺�����
 * 	�׺���:����Ϊ�����͵�һ�����֡�
 * ����:��ÿһ�����ֵ������Ͳ���֤���������Ƿ����ԭ���֡�
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
