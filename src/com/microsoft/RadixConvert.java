package com.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RadixConvert {

	public static void main(String []args){
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));
		HashMap<Character, Integer> lookup = new HashMap<>();
			for(int i=0 ;i<=9;i++){
				lookup.put((char)(48+i), i);
			}
			for(int i=10;i<36;i++){
				lookup.put((char)(87+i),i);
			}
		String input ;
			try {
				while((input=br.readLine())!=null){
					String[] splitedInput =input.split(",");
					String memDump = splitedInput[0];
					Integer oldRadix=Integer.valueOf(splitedInput[1]);
					Integer newRadix=Integer.valueOf(splitedInput[2]);
					if(oldRadix>36||oldRadix<2||newRadix>36||newRadix<2){
						System.out.println("Invalid Input");
					}
					Integer sum =0;
					int power =memDump.length()-1;
					for(int i=0;i<memDump.length();i++)
					{
						Integer num = lookup.get(memDump.charAt(i));
						sum=sum+num*((int) Math.pow(oldRadix,power));
						power--;
					}
					StringBuilder output=new StringBuilder();
					while(sum>0){
						int rem = sum%newRadix;
						sum = sum/newRadix;
						output=output.append(Character.forDigit(rem, newRadix));
						
					
					}
					System.out.println(output.reverse());
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
