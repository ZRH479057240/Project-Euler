package Euler;

import java.math.BigInteger;

/*
 * ����:��100���ĸ�����λ�ĺ�
 * ����:100���Ľ׳����ּ���,���Բ���������ģ��˷����м���
 * 
 * �Լ��ķ���:
 * 	ʱ��:4hours
 * 	Ч��:240ms
 * ϵͳ�ķ���:
 * 	ʱ��:10mins
 * 	Ч��:26ms
 * 
 * ��ʵ֤��,����ϵͳ�������Լ���дЧ�ʸߺܶ�
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
		
		System.out.println("��������ʱ��:"+(System.currentTimeMillis()-time)+"ms");
	}
	
	
	//������ʵ�ֳ˷�
	private static int[] multiply(int[] multiplier , int[] multiplicand){
		//�жϽ����λ��
		int length = getProductDigit(multiplier, multiplicand);
		int[] answer = new int[length];
		int CF = 0;//��λ����
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
	//��ȡ��int���ָ�λ���ֹ��ɵ�����
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
	//�ж���������ͽǱ��Ƿ�Ϸ�
	private static boolean isLegal(int[] number, int index){
		return index>=0 && index<number.length;
	}
	//���ش�������ĳ˻���λ��
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
