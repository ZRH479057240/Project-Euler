package Euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MaximumPathSum_1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(new File("maximumPath.txt"));
		BufferedReader br = new BufferedReader(fr);
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		String s = null;
		while((s = br.readLine())!=null){
			ArrayList<Integer> node = new ArrayList<Integer>();
			String[] number = s.split(" ");
			for(String x : number){
				node.add(Integer.parseInt(x));
			}
			g.add(node);
		}
		
		
		int[] sum=new int[1<<g.get(g.size()-1).size()-1];
		int path = 0;
		while(path<sum.length){
			sum[path]=getNumber(path , g);
			path++;
		}
		System.out.println(Arrays.stream(sum).max());
	}
	static int getNumber(int path , ArrayList<ArrayList<Integer>> g){
		char[] digit = decimal2binary(path , g.size()).toCharArray();
		int answer = 0;
		int index=0;
		System.out.println();
		for(int i = 0 ; i<g.size() ; i++){
			index += index<path ? digit[i]-48:0;
			answer += g.get(i).get(index);
		}
		return answer;
	}
	public static String decimal2binary(int decNum , int digit) {
        String binStr = "";
        for(int i= digit-1;i>=0;i--) {
            binStr +=(decNum>>i)&1;
        }
        return binStr;
    }
}
