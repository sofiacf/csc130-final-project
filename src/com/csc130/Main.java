package com.csc130;

import com.csc130.graph_search.Graph;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			System.out.println();
			System.out.println("Trial # " + i);
			runGraphTrial(i);
		}
	}

	private static void runGraphTrial(int i) {
		Graph graph = new Graph((int) Math.pow(10, i));
		graph.seedGraph();
		LocalDateTime start = startTimer();
		graph.queueBFS(1);
		stopTimer(start, "Queue BFS");

		start = startTimer();
		graph.DFSRecursion(1);
		stopTimer(start, "Recursive DFS");

		start = startTimer();
		graph.iterativeDFS(1);
		stopTimer(start, "Stack DFS");
		System.out.println("________________________________________________________________________________________________________________");
	}

	private static LocalDateTime startTimer() {
		return LocalDateTime.now();
	}
	private static void stopTimer(LocalDateTime start, String algorithmName) {
		LocalDateTime end = LocalDateTime.now();
		System.out.println(algorithmName + " time in nanoseconds: " + Duration.between(start, end).getNano());
	}
}
