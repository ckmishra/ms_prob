package com.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
	static List<Integer> list = new ArrayList();
	static String output;

	public static void main(String args[]) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			String input;

			while ((input = br.readLine()) != null) {
				list.clear();
				if (Integer.valueOf(input) == 1) {
					System.out.println("happy 0");
				} else {
					String output = isHappyNumber((Integer.valueOf(input)));
					System.out.println(output);
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static String isHappyNumber(int inputNum) {
		list.add(inputNum);
		int num = 0;
		while (inputNum > 0) {
			int temp = inputNum % 10;
			num = (temp * temp) + num;
			inputNum = inputNum / 10;
		}
		if (list.contains((Integer) num)) {
			output = "unhappy " + list.size();
		} else {
			if (num == 1) {
				output = "happy " + list.size();
			} else {
				isHappyNumber(num);
			}
		}

		return output;
	}
}
