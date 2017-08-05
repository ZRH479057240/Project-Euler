package Euler;

/*
 * 问题:求二十世纪有多少个月初是星期日。
 * 方案:1900年1月1日是星期日,求每个月月初与第一天的距离,是7的倍数即为星期日。
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
