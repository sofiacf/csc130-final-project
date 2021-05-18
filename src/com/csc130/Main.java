package com.csc130;

import com.csc130.graph_search.Graph;
import com.csc130.list_search.ListSearcher;
import com.csc130.sort.Sorter;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i < 4; i++) {
			System.out.println();
			System.out.println("Trial # " + i);
			runGraphTrial(i);
			runListSearchTrial(i);
			runArraySortTrial(i);
		}
	}

	private static void runArraySortTrial(int i) {
		// Don't go past 20 in Math.pow. The recursion depth will be insane and you machine will take off.
		int size = (int) Math.pow(20, i);
		Sorter sort = new Sorter(size);
		sort.seedArray();

		LocalDateTime start = startTimer();
		sort.bubbleSort();
		stopTimer(start, "Bubble Sort");

		start = startTimer();
		sort.insertionSort();
		stopTimer(start, "Insertion Sort");

		int begin = 0;
		int end = sort.getLength()-1;
		start = startTimer();
		sort.quickSort(begin, end);
		stopTimer(start, "Quick Sort");

		start = startTimer();
		sort.selectionSort();
		stopTimer(start, "Selection Sort");

		start = startTimer();
		sort.mergeSort(sort);
		stopTimer(start, "Merge Sort");

		System.out.println("________________________________________________________________________________________________________________");
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
		System.out.println("________________________________________________________________________________________________________________");
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
