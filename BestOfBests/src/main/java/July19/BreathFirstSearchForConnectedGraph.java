//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
package July19;

import java.util.Iterator;
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
    void addEdge(int verticesIndex,int adjVertices) 
    { 
        adj[verticesIndex].add(adjVertices); 
    } 

    // prints BFS traversal from a given source s 
	private void BFS(int startIndex) {

        // Mark all the vertices as not visited(By default 
        // set as false) 
        boolean visited[] = new boolean[vertices]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[startIndex]=true; 
        queue.add(startIndex); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            startIndex = queue.poll(); 
            System.out.print(startIndex+" "); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            Iterator<Integer> i = adj[startIndex].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
		
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
