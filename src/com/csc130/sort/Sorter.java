package com.csc130.sort;

import java.util.List;

public class Sorter {

	private final List<Integer> list;
	public Sorter(List<Integer> list) {
		this.list = list;
	}

	public void bubbleSort(int[] array) {
		int n = array.length;
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
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

	public void quickSort(int[] array, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(array, begin, end);

			quickSort(array, begin, partitionIndex-1);
			quickSort(array, partitionIndex+1, end);
		}
	}

	// Partition method is for the quickSort method.
	private int partition(int[] array, int begin, int end) {
		int pivot = array[end];
		int i = (begin-1);

		for (int j = begin; j < end; j++) {
			if (array[j] <= pivot) {
				i++;

				int swapTemp = array[i];
				array[i] = array[j];
				array[j] = swapTemp;
			}
		}
		int swapTemp = array[i+1];
		array[i+1] = array[end];
		array[end] = swapTemp;

		return i+1;
	}

	public void selectionSort(int[] array) {
		int n = array.length;

		for (int i = 0; i < n-1; i++) {
			int min_idx = i;
			for (int j = i+1; j < n; j++) {
				if (array[j] < array[min_idx]) {
					min_idx = j;
				}
			}

			int temp = array[min_idx];
			array[min_idx] = array[i];
			array[i] = temp;
		}
	}

	public void mergeSort(int[] array, int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int[] L = new int[n1];
		int[] R = new int[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			}
			else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// mergeSort()
	public void sort(int[] array, int l, int r) {
		if (l < r) {
			// Find the middle point
			int m =l+ (r-l)/2;

			// Sort first and second halves
			sort(array, l, m);
			sort(array, m + 1, r);

			// Merge the sorted halves
			mergeSort(array, l, m, r);
		}
	}
}
