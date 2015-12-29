package com.microsoft;

import java.util.Scanner;

public class Staircase {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int numOfTestCase = Integer.valueOf(s.next());

		while (numOfTestCase > 0) {
			int n = s.nextInt();
			int k = s.nextInt();
			int p = s.nextInt();
			Integer[] aStairs = new Integer[n];
			for(int i =0;i<n;i++){
				aStairs[i]=s.nextInt();
			}
			Integer[] bStairs = new Integer[n];
			for(int i =0;i<n;i++){
				bStairs[i]=s.nextInt();
			}
			int cost = calculateCost(n, k, p, aStairs, bStairs);
			System.out.println(cost);
			numOfTestCase--;
		}

	}

	private static int calculateCost(int n, int k, int p, Integer[] aStairs,
			Integer[] bStairs) {

		Integer[] a = aStairs; 
		Integer[] b = bStairs;
	
		int cost = (a[0] <= b[0]) ? a[0] : b[0];
		for (int i = 0; i < n-1; i=i+k) {
			int next = a[i + 1];
			int nextStair = (b[i + 1] + p);
			int nextStep=10000000;
			int nextStepOtherStair=10000000;
			if(i + k < n){
				 nextStep = (a[i + k]);
				 nextStepOtherStair = (b[i + k]) + p;
			}
			int min =min(next, nextStair, nextStep, nextStepOtherStair);
			cost = cost + min;
		}

		return cost;
	}

	// find min among four
	private static int min(int next, int nextStair, int nextStep,
			int nextStepOtherStair) {
		int min_1 = Math.min(next, nextStair);
		int min_2 = Math.min(nextStep, nextStepOtherStair);
		int min = Math.min(min_1, min_2);
		return min;

	}
}
