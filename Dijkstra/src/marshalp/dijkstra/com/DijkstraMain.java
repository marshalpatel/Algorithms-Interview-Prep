package marshalp.dijkstra.com;

public class DijkstraMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Graph g = new Graph(5);
		
//		g.addEdges(0,1,10);
//		g.addEdges(0,3,5);
//		g.addEdges(1,2,1);
//		g.addEdges(1,3,2);
//		g.addEdges(2,4,4);
//		g.addEdges(3,1,3);
//		g.addEdges(3,2,9);
//		g.addEdges(3,4,2);
//		g.addEdges(4,0,7);
//		g.addEdges(4,2,6);
//		
//		int[] distance = g.dijkstra(0);
//		
//		for(int i =0;i<distance.length;i++){
//			System.out.println(distance[i]);
//		}
		
		
		g.addUndirectedEdge(0,1,3);
		g.addUndirectedEdge(0,2,4);
		
		g.addUndirectedEdge(3,1,6);
		g.addUndirectedEdge(4,1,2);
		g.addUndirectedEdge(1,2,5);
		g.addUndirectedEdge(2,4,7);
		
		
		int[] distance = g.prims(0);
		
		for(int i =0;i<distance.length;i++){
			System.out.println(distance[i]);
		}

	}

}
