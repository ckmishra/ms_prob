package com.microsoft;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Pick {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String args[])   {
		Scanner s = new Scanner(System.in);
		int totalAvaialbleTime = s.nextInt();
		List<Problem> arrayProblem = new ArrayList<>();
		while (s.hasNext()) {
			String[] input = s.next().split(",");
			Problem p = new Problem(input[0], input[1], input[2]);
			arrayProblem.add(p);
		}

		Result res = maxScore(arrayProblem, totalAvaialbleTime);
		System.out.println(res.totalTime);
		System.out.println(res.getIds());
	}

	private static Result maxScore(List<Problem> problems,
			double totalAvaialbleTime) {
		Collections.sort(problems, new WeightComprator());
		int i = 0;
		List<String> result = new ArrayList<>();
		int finalScore = 0;
		while (totalAvaialbleTime > 0) {
			Problem p = problems.get(i++);
			if (totalAvaialbleTime >= p.getTimeTaken()) {
				finalScore = (int) (finalScore + p.getScore());
				result.add(String.valueOf(p.getId()));
			} else {
				finalScore = (int) (finalScore + totalAvaialbleTime
						* p.getWeightedValue());
				result.add(String.valueOf(p.getId() + "*"));
			}
			totalAvaialbleTime = totalAvaialbleTime - p.getTimeTaken();
		}
		Collections.sort(result);
		Result finalResult = new Result(result, finalScore);
		return finalResult;
	}
}

class Problem {
	int id;
	double score;
	double timeTaken;
	
	Problem() {
	}

	Problem(String i, String s, String time) {
		id = Integer.valueOf(i);
		score = Double.valueOf(s);
		timeTaken = Double.valueOf(time);
	}

	public int getId() {
		return id;
	}

	public double getScore() {
		return score;
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public double getWeightedValue() {
		return score / timeTaken;
	}

}

class Result {
	List<String> ids = new ArrayList<String>();
	Integer totalTime;
	Result(List<String> id, int time) {
		ids = id;
		totalTime = time;
	}
	
	public List<String> getIds() {
		return ids;
	}
	public Integer getTotalTime() {
		return totalTime;
	}
}

class WeightComprator implements Comparator<Problem> {
	@Override
	public int compare(Problem o1, Problem o2) {
		if (o1.getWeightedValue() > o2.getWeightedValue())
			return -1;
		if (o1.getWeightedValue() < o2.getWeightedValue())
			return 1;
		return 0;
	}

}