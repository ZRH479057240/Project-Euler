package Euler;

import java.util.ArrayList;
import java.util.Iterator;

public class PowerDigitSum {
	public static void main(String[] args) {
		int sum = 0;
		ArrayList<Integer> number = new ArrayList<Integer>();
		number.add(2);
		for(int i=1;i<1000;i++){
			number = getNumber(number);
		}
		for(int i=0;i<number.size();i++){
			sum+=number.get(i);
		}
		System.out.println(sum);
	}
	static ArrayList<Integer> getNumber(ArrayList<Integer> nums){
		ArrayList<Integer> number = new ArrayList<Integer>();
		Iterator<Integer> iterator = nums.iterator();
		Integer temp = new Integer(0);
		int CF=0;
		while(iterator.hasNext()){
			temp=iterator.next();
			if(temp>=5){
				if(CF==0)
					number.add((temp<<1)-10);
				else
					number.add((temp<<1)-9);
				CF=1;
			}else{
				if(CF==0)
					number.add(temp<<1);
				else
					number.add((temp<<1)+1);
				CF=0;
			}
		}
		if(CF==1)
			number.add(1);
		return number;
	}
}
