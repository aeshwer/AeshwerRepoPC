//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
package July19;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearchForConnectedGraph {

	private int vertices; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	public DepthFirstSearchForConnectedGraph(int vertices) {
		this.vertices = vertices;
		this.adj = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int verticesIndex, int adjVertices) {
		adj[verticesIndex].add(adjVertices);
	}

	// prints BFS traversal from a given source startIndex
	private void DFSUtil(int startIndex, boolean visited[]) {

		// Mark the current node as visited and print it
		visited[startIndex] = true;
		System.out.print(startIndex + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[startIndex].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}

	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int startIndex) {
		// Mark all the vertices as not visited(set asstartIndex
		// false by default in java)
		boolean visited[] = new boolean[vertices];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(startIndex, visited);
	}

	public static void main(String[] args) {
		DepthFirstSearchForConnectedGraph g = new DepthFirstSearchForConnectedGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);
	}

}
