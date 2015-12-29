package com.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MatrixMultiplication {

	
	public static void main(String args[]){
	
		BufferedReader br = new BufferedReader(new InputStreamReader(
				System.in));

		String input;

		try {
			while ((input = br.readLine()) != null) {
			
				char[] inputChar =input.toCharArray();
				int count =0;
				for(int i =0;i<inputChar.length;i++){
					if(inputChar[i]=='|'){
						count++;
					}
				}
				int numOfMatrix = count/2;
	
				String[] firstRows = input.split("| |");
				
				
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
