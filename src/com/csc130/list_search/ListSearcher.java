package com.csc130.list_search;

import java.util.ArrayList;
import java.util.List;

public class ListSearcher {
	private List<Integer> list;
	private int size;

	public ListSearcher(int size) {
		this.size = size;
		this.list = new ArrayList<>();
	}

	public void seedList() {
		for (int i = 0; i < size; i++) {
			list.add(i);
		}
	}

	public int sequentialSearch(int x) {
		for (int i : list) {
			if (i == x) return i;
		}
		return -1;
	}

	public int binarySearch(int x) {
		return binarySearch(0, list.size(), x);
	}

	private int binarySearch(int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;

			if (list.get(mid) == x) {
				return mid;
			}

			if (list.get(mid) > x) {
				return binarySearch(low, mid - 1, x);
			}

			return binarySearch(mid + 1, high, x);
		}
		return -1;
	}
}
