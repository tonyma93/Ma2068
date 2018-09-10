package lab8;

import edu.uci.ics.jung.graph.Graph;

public class findPassword {

	public <V,E> void Password(Graph<V,E> g){
		while(g.getVertexCount()!= 0){
			V toRemove = null;
			for( V v : g.getVertices()){
				if(g.inDegree(v)==0){
					toRemove = (V) v;
					System.out.print(v);
					g.removeVertex(v);
					break;

				}
			}
		}
	}}