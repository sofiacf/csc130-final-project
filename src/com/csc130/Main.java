package com.csc130;

import com.csc130.graph_search.Graph;
import com.csc130.list_search.ListSearcher;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			System.out.println();
			System.out.println("Trial # " + i);
			runGraphTrial(i);
			runListSearchTrial(i);
		}
	}

	private static void runListSearchTrial(int i) {
		int size = (int) Math.pow(50, i) * 420;
		ListSearcher searcher = new ListSearcher(size);
		searcher.seedList();

		LocalDateTime start = startTimer();
		searcher.sequentialSearch((int) (size * .69));
		stopTimer(start, "sequentialSearch");

		start = startTimer();
		searcher.binarySearch((int) (size * .69));
		stopTimer(start, "binarySearch");
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
