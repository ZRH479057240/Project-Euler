package Euler;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * ����:�����в��ɳ�Ϊ�����Ƿḻ���ĺ͵������ܺ͡�
 * 	�ḻ��:Լ���ʹ��ڱ������
 * 	����:����28123�����ֱض����Ա�ʾΪ�����ḻ��֮��
 * ����1:��ȡ�Ƿḻ���б�,��ÿһ�����ֽ����ж������ //����ʱ��:2522675.0
 * ����2:��ȡ���з�Χ�ڷḻ���ĺ�,��ʣ���������//����ʱ��:9756.0
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
		
		
		//����1
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
		
		//����2
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
