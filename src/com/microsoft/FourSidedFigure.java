package com.microsoft;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourSidedFigure {

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numInput = Integer.valueOf(br.readLine());

		for (int i = 0; i < numInput; i++) {
			String s = br.readLine();
			String[] splitedString = s.split(" ");
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < splitedString.length; j++) {
				list.add(Integer.valueOf(splitedString[j]));
			}

			Collections.sort(list);
			int sum = (list.get(0) + list.get(1) + list.get(2));
			if (sum > list.get(3)) {
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}

}
