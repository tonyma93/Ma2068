package lab8;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
public class Euler {

	@SuppressWarnings("unchecked")
	public static <V, E> void main(String[] args) {
		Graph  g= new SparseGraph();
		String fileName = "p079_keylog.txt";
		String line = null;
		int edge = 1 ;
		BufferedReader bufferedReader;

		try {

			bufferedReader= new BufferedReader(new FileReader(fileName));

			while(bufferedReader.ready()) {
				line = bufferedReader.readLine();
				String[] components = line.split(""); //split each number
				for(int i = 0; i < components.length-1;i++){
					g.addEdge(edge, line.charAt(i),line.charAt(i+1),EdgeType.DIRECTED);
					edge++;
				}
				
				
			}

			bufferedReader.close();         
		}
		

		catch(FileNotFoundException e) { 
			System.err.println("File not found");                
		}
		// catch any other exception
		catch(Exception e) {
			e.printStackTrace();
		}
		findPassword f = new findPassword();
		f.Password(g);
	}

}
