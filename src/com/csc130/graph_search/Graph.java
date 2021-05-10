package com.csc130.graph_search;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

class Graph {
	int V;

	LinkedList<Integer>[] lists;

	Graph(int V) {
		this.V = V;
		lists = new LinkedList[V];

		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<>();
		}
	}

	void addEdge(int v, int w) {
		lists[v].add(w);
	}

	void iterativeeDFS(int s) {
		Vector<Boolean> visited = new Vector<>(V);
		for (int i = 0; i < V; i++) {
			visited.add(false);
		}

		Stack<Integer> stack = new Stack<>();

		stack.push(s);

		while (!stack.empty()) {
			s = stack.peek();
			stack.pop();

			if (!visited.get(s)) {
				System.out.print(s + " ");
				visited.set(s, true);
			}

			for (int v : lists[s]) {
				if (!visited.get(v))
					stack.push(v);
			}
		}
	}

	void recursiveDFS(int s) {
//		TODO: implement this!
	}

	void queueBFS(int s) {
//		TODO: implement this!
	}

	void stackBFS(int s) {
//		TODO: implement this too!
	}
}
