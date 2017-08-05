package Euler;

/*
 * ����:���ʮ�����ж��ٸ��³��������ա�
 * ����:1900��1��1����������,��ÿ�����³����һ��ľ���,��7�ı�����Ϊ�����ա�
 * 
 */


public class CountingSundays {
	public static void main(String[] args) {
		int[] noLeapMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] leapMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
		int[] month;
		int day = 0;
		int Sunday = 0;
		for(int year = 1901 ; year < 2001 ; year++ ){
			if(isLeap(year))
				month = leapMonth;
			else
				month = noLeapMonth;
			for(int i = 0 ; i < 12 ; i++ ){
				if(day%7 == 0)
					Sunday++;
				System.out.println(year+"->"+day+"->"+day%7+"->"+Sunday);
				day+= month[i];
			}
		}
		System.out.println(Sunday);
	}
	public static boolean isLeap(int year){
		return year%400==0 || year%4==0 && year%100!=0;
		
	}
}
