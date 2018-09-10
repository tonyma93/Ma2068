package lab7;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

public class Graph1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph<String,Integer> g = new SparseGraph<String, Integer>();
		g.addEdge(1, "A","B");
		g.addEdge(2, "B","D");
		g.addEdge(3, "C","D");
		g.addEdge(4, "D","E");
		g.addEdge(5, "E","F");
		g.addEdge(6, "F","A");
		System.out.println(g);
		//DFS(g);
	}
	/* public static <V,E> void DFS(Graph <V,E> g){
	    V start = null;      
	    for (V v:g.getVertices()){
	        if(v.toString().equals("0"))
	           start = v; 
	    }

	    Set visited = new HashSet();
	    LinkedList stack = new LinkedList();
	    stack.add(start);
	    // traverse through graph in depth-first order
	    while (!stack.isEmpty())
	    {
	        V v = (V)stack.removeFirst();
	        visited.add(v);
	        Set neighbors = (Set) g.getNeighbors(v);

	        for (Iterator n_it = neighbors.iterator(); n_it.hasNext(); )
	        {
	            V w = (V)n_it.next();

	            if (!visited.contains(w)){
	                System.out.println(w.toString());
	                stack.addFirst(w);
	            }
	        }
	    }
        }*/
	public static <V,E> void BFS(Graph <V,E> g){
		
	}
	
		
	}

