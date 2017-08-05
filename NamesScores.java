package Euler;

/*
 * 问题:求文档内所有姓名的加权和
 * 	姓名的权重是该姓名的序号
 * 方案:用stream实现对姓名的快速操作
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class NamesScores {
	public static void main(String[] args) throws IOException {
		int sum = 0;
		FileReader fr = new FileReader(new File("names.txt"));
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
//		String str = "\"ABC\",\"BCD\"";
		String[] name = str.split(",");
		ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(name));
		name = nameList.stream().sorted().toArray(String[]::new);
		for(int i=0; i<name.length ; i++){
			sum+=getWeight(name[i],i+1);
		}
		System.out.println(sum);
	}
	private static int getWeight(String name, int index){
		int sum = 0;
		char[] letter = name.toCharArray();
		for(char x : letter){
			if(x!='\"'){
				System.out.print(x);
				sum+=(x-64)*index;
			}
		}
		System.out.println();
		return sum;
	}
}
