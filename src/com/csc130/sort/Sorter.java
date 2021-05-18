package com.csc130.sort;

import java.util.Arrays;
import java.util.Random;

public class Sorter {

	private int size;
	private int[] array;

	public Sorter(int size) {
		this.size = size;
		this.array = new int[size];
	}

	public void seedArray() {
		for (int i = 0; i < size; i++) {
			array[i] = randomFill();
		}
	}

	public static int randomFill() {
		return (new Random()).nextInt();
	}

	public void bubbleSort() {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public void insertionSort() {

		for (int i = 1; i < size; i++) {
			int temp = array[i];
			int j = i - 1;

			while (j >= 0 && temp < array[j]) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = temp;
		}
	}

	public int getStart() {
		return this.array[0];
	}

	public int getEnd() {
		return this.array[this.array.length - 1];
	}

	public int getLength() {
		return this.array.length;
	}

	public void quickSort(int begin, int end) {

		int partition = partition(begin, end);

		if (partition - 1 > begin) {
			quickSort(begin, partition - 1);
		}
		if (partition + 1 < end) {
			quickSort(partition + 1, end);
		}
	}

	public int partition(int start, int end) {
		int pivot = array[end];

		for (int i = start; i < end; i++) {
			if (array[i] < pivot) {
				int temp = array[start];
				array[start] = array[i];
				array[i] = temp;
				start++;
			}
		}

		int temp = array[start];
		array[start] = pivot;
		array[end] = temp;

		return start;
	}

	public void selectionSort() {

		for (int i = 0; i < size - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < size; j++) {
				if (array[j] < array[min_idx]) {
					min_idx = j;
				}
			}

			int temp = array[min_idx];
			array[min_idx] = array[i];
			array[i] = temp;
		}
	}

	public void mergeSort(Sorter array) {
		int low = 0;
		int high = array.getLength() - 1;

		// sort array `A[]` using a temporary array `temp`
		int[] temp = Arrays.copyOf(this.array, array.getLength());

		// divide the array into blocks of size `m`
		// m = [1, 2, 4, 8, 16…]
		for (int m = 1; m <= high - low; m = 2 * m) {
			// for m = 1, i = 0, 2, 4, 6, 8 …
			// for m = 2, i = 0, 4, 8, 12 …
			// for m = 4, i = 0, 8, 16 …
			// …
			for (int i = low; i < high; i += 2 * m) {
				int from = i;
				int mid = i + m - 1;
				int to = Integer.min(i + 2 * m - 1, high);

				merge(array, temp, from, mid, to);
			}
		}
	}

	public void merge(Sorter array, int[] temp, int from, int mid, int to) {
		int k = from, i = from, j = mid + 1;
		int[] A = Arrays.copyOf(this.array, array.getLength());

		// loop till no elements are left in the left and right runs
		while (i <= mid && j <= to) {
			if (A[i] < A[j]) {
				temp[k++] = A[i++];
			} else {
				temp[k++] = A[j++];
			}
		}

		// copy remaining elements
		while (i <= array.getLength() / 2) {
			temp[k++] = A[i++];
		}

        /* no need to copy the second half (since the remaining items
           are already in their correct position in the temporary array) */

		// copy back to the original array to reflect sorted order
		for (i = from; i <= to; i++) {
			A[i] = temp[i];
		}
	}
}
