package Euler;

import java.util.HashMap;

public class NumberLetterCount {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1;i<1001;i++){
			sum+=getString(i).length();
		}
		System.out.println(sum);
	}
	static String getString(int number){
		int[] digit =new int[4];
		StringBuffer result = new StringBuffer();
		String str = null;
		HashMap<Integer , String> numberMap = new HashMap<Integer , String>();
		numberMap.put(0, "");
		numberMap.put(1, "one");
		numberMap.put(2, "two");
		numberMap.put(3, "three");
		numberMap.put(4, "four");
		numberMap.put(5, "five");
		numberMap.put(6, "six");
		numberMap.put(7, "seven");
		numberMap.put(8, "eight");
		numberMap.put(9, "nine");
		numberMap.put(10, "ten");
		numberMap.put(11, "eleven");
		numberMap.put(12, "twelve");
		numberMap.put(13, "thirteen");
		numberMap.put(14, "fourteen");
		numberMap.put(15, "fifteen");
		numberMap.put(16, "sixteen");
		numberMap.put(17, "seventeen");
		numberMap.put(18, "eighteen");
		numberMap.put(19, "nineteen");
		numberMap.put(20, "twenty");
		numberMap.put(30, "thirty");
		numberMap.put(40, "forty");
		numberMap.put(50, "fifty");
		numberMap.put(60, "sixty");
		numberMap.put(70, "seventy");
		numberMap.put(80, "eighty");
		numberMap.put(90, "ninety");
		digit[3] = number/1000;
		digit[2] = number%1000/100;
		digit[1] = number%100/10;
		digit[0] = number%10;
		for(int i=3; i>-1; i--){
			if(digit[i]!=0){
				switch (i){
				case 3:
					str = "onethousand";
					result.append(str);
					break;
				case 2:
					str = numberMap.get(digit[2])+"hundred";
					if(result.length()!=0)
						result.append("and");
					result.append(str);
					break;
				case 1:
					if(digit[1]!=1)
						str = numberMap.get(digit[1]*10)+numberMap.get(digit[0]);
					else
						str = numberMap.get(digit[1]*10+digit[0]);
					if(result.length()!=0)
						result.append("and");
					result.append(str);
					break;
				case 0:
					str = numberMap.get(digit[0]);
					if(digit[1]==0){
						if(result.length()!=0)
							result.append("and");
						result.append(str);
					}
					break;
				}
			}
		}
		return result.toString();
	}
}

