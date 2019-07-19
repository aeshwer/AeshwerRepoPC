//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
package July19;

import java.util.LinkedList;

public class BreathFirstSearchForConnectedGraph {

	private int vertices; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	// Constructor
	public BreathFirstSearchForConnectedGraph(int vertices) {
		this.vertices = vertices;
		this.adj = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i)
			adj[i] = new LinkedList();
	}
	

    // Function to add an edge into the graph 
    void addEdge(int startVertices,int endVertices) 
    { 
        adj[startVertices].add(endVertices); 
    } 

    // prints BFS traversal from a given source s 
	private void BFS(int startIndex) {

		
	}
	public static void main(String[] args) {
		BreathFirstSearchForConnectedGraph g = new BreathFirstSearchForConnectedGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}


}
