package com.csc130.list_search;

import java.util.List;

public class ListSearcher {
	private List<Integer> list;
	public ListSearcher(List<Integer> list) {
		this.list = list;
	}

	public int sequentialSearch(int x) {
		for (int i : list) {
			if (i == x) return i;
		}
		return -1;
	}

	public int binarySearch(int low, int high, int x) {
		if (high >= low) {
			int mid = low + (high - low) / 2;

			if (list.get(mid) == x)
				return mid;

			if (list.get(mid) > x)
				return binarySearch(low, mid - 1, x);

			return binarySearch(mid + 1, high, x);
		}
		return -1;
	}
}
