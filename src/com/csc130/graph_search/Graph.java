package com.csc130.graph_search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
	int V;

	LinkedList<Integer>[] lists;

	public Graph(int V) {
		this.V = V;
		lists = new LinkedList[V];

		for (int i = 0; i < lists.length; i++) {
			lists[i] = new LinkedList<>();
		}
	}

	public void addEdge(int v, int w) {
		lists[v].add(w);
	}

	public void seedGraph() {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				addEdge(i, j);
			}
		}
	}

	public void iterativeDFS(int startVertex) {
		boolean[] visited = new boolean[V];

		Stack<Integer> stack = new Stack<>();

		stack.push(startVertex);

		while (!stack.empty()) {
			startVertex = stack.peek();
			stack.pop();

			visited[startVertex] = true;

			for (int v : lists[startVertex]) {
				if (!visited[v]) stack.push(v);
			}
		}
	}

	public void DFSRecursion(int startVertex) {
		boolean[] visited = new boolean[V];
		recursiveDFS(startVertex, visited);
	}

	private void recursiveDFS(int start, boolean[] visited) {
		visited[start] = true;
		for (int i = 0; i < lists[start].size(); i++) {
			int destination = lists[start].get(i);
			if (!visited[destination])
				recursiveDFS(destination, visited);
		}
	}

	public void queueBFS(int startVertex) {
		boolean[] visited = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[startVertex] = true;
		queue.add(startVertex);

		while (queue.size() != 0) {
			startVertex = queue.poll();
			Iterator<Integer> i = lists[startVertex].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
}
