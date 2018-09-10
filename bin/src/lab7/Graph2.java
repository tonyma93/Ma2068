package lab7;
import java.io.*;
import java.util.*;

public class Graph2{
	private static int V;   // No. of vertices
	private static LinkedList<Integer> adj[]; //Adjacency Lists

	// Constructor
	public Graph2(int v){
		this.V = v;
		this.adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	public void addEdge(int v,int w){
		this.adj[v].add(w);
	}


	public static void BFS(int s){

		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s]=true;
		queue.add(s);

		while (queue.size() != 0){
			s = queue.poll();
			System.out.print(s+" ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()){
				int n = i.next();
				if (!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void DFS(int s){

		boolean visited[] = new boolean[V];

		LinkedList<Integer> stack = new LinkedList<Integer>();


		visited[s]=true;
		stack.push(s);

		while (stack.size() != 0){
			s = stack.pop();
			System.out.print(s+" ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()){
				int n = i.next();
				if (!visited[n]){
					visited[n] = true;
					stack.push(n);

				}
				
			}
		}
	}
	/*public static void DFS(int s){
		boolean visited[] = new boolean[V];
		DFS2(s, visited);
	}
	public static void DFS2(int v,boolean visited[]){
		visited[v] = true;
		System.out.print(v+" "); //print visited node

		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()){
			int n = i.next();
			if (!visited[n]){
				DFS2(n, visited);
			}
		}
	}*/
	public static void main(String args[]){
		Graph2 g = new Graph2(5);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(1, 4);

		g.DFS(0); //discovery order
		System.out.println("");
		g.BFS(0);
	}
}