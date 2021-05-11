package com.csc130.sort;

import java.util.List;

public class Sorter {

	private List<Integer> list;
	public Sorter(List<Integer> list) {
		this.list = list;
	}

	public bubbleSort() {
//		todo: implement this!
	}

	public void insertionSort() {
		int n = list.size();

		for (int i = 1; i < n; i++) {
			Integer temp = list.get(i);
			int j = i - 1;

			while (j >= 0 && temp < list.get(j)) {
				list.set(j + 1, list.get(j));
				j--;
			}

			list.set(j + 1, temp);
		}
	}

	public quickSort() {
//		todo: implement this!
	}

	public selectionSort() {
//		todo: implement this!
	}

	public mergeSort() {
//		todo: implement this! or shellsort!
	}
}
