package marshalp.dijkstra.com;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class Graph {

	Node[] g;

	public Graph(int n) {

		this.g = new Node[n];

		for (int i = 0; i < n; i++) {

			this.g[i] = new Node(i);
		}

	}

	public void addEdges(int s, int d, int w) {

		LinkedList<Node> e = this.g[s].edges;

		Node newNoode = new Node(d);
		newNoode.weight = w;

		if (e == null) {
			e = new LinkedList<Node>();
			this.g[s].edges = e;
		}

		e.add(newNoode);

	}
	
	

    public void addUndirectedEdge(int s, int d, int w){
        
        LinkedList<Node> s_e = this.g[s].edges;
        
        if(s_e==null){
            s_e = new LinkedList<Node>();
        }
        
        Node dest = new Node(this.g[d].value);
        dest.weight = w;
        s_e.add(dest);
        
        this.g[s].edges = s_e;
        
        LinkedList<Node> d_e = this.g[d].edges;
        
        if(d_e==null){
            d_e = new LinkedList<Node>();
        }
        
        Node source = new Node(this.g[s].value);
        source.weight = w;
        d_e.add(source);
        
        this.g[d].edges = d_e;    
    }
	
	
	public int[] prims(int start){
        
        boolean[] inTree = new boolean[this.g.length]; 
        int[] distance = new int[this.g.length];
        
        for(int i = 0;i<distance.length;i++)
            distance[i]=Integer.MAX_VALUE;
        
        distance[start] = 0;
        
        Node s = this.g[start];
        
        while(!inTree[s.value]){
            
            inTree[s.value] = true;
            LinkedList<Node> edges = s.edges;
            
            ListIterator<Node> itr = edges.listIterator();
            
            while(itr.hasNext()){
                
                Node d = itr.next();
                
                if(distance[d.value] > d.weight && !inTree[d.value]){
                    
                    distance[d.value] = d.weight;
                    
                }
                
            }
            
            int min_dist = Integer.MAX_VALUE;
            int idx = 0;
            
            for(int i = 0; i<distance.length; i++){
                
                if(min_dist > distance[i] && !inTree[i]){
                    min_dist = distance[i];
                    idx = i;
                }
            }
            
            s = this.g[idx];
            
        }
        
        return distance;
    }
    



	public int[] dijkstra(int start) {

		PriorityQueue<Node> pq = new PriorityQueue<Node>(
				new DistanceComparator());

		pq.offer(this.g[start]);

		boolean[] inTree = new boolean[this.g.length];
		int[] distance = new int[g.length];

		for (int i = 0; i < distance.length; i++)
			distance[i] = Integer.MAX_VALUE;

		distance[start] = 0;
		Node s = this.g[start];

		// System.out.println(s.edges.size());
		/*
		 * while (!inTree[s.value]) { inTree[s.value] = true;
		 * LinkedList<Node> edges = s.edges; ListIterator<Node> itr =
		 * 
		 * edges.listIterator();
		 * 
		 * while (itr.hasNext()) { Node d = itr.next();
		 * 
		 * if (distance[d.value] > d.weight + distance[s.value]) {
		 * distance[d.value] = d.weight + distance[s.value];
		 * 
		 * } }
		 * 
		 * int minWeight = Integer.MAX_VALUE; int minDistance = 0;
		 * 
		 * for (int i = 0; i < distance.length; i++) {
		 * 
		 * if (minWeight > distance[i] && !inTree[this.g[i].value]) {
		 * 
		 * minWeight = distance[i]; minDistance = i; }
		 * 
		 * }
		 * 
		 * s = this.g[minDistance];
		 * 
		 * }
		 * 
		 * return distance;
		 */

		while (!pq.isEmpty()) {

			Node v = this.g[pq.poll().value];
			LinkedList<Node> edges = v.edges;
			ListIterator<Node> itr = edges.listIterator();

			while (itr.hasNext()) {
				Node d = itr.next();

				if (distance[d.value] > d.weight + distance[v.value]) {
					distance[d.value] = d.weight + distance[v.value];

					Node newNode = new Node(d.value);
					newNode.weight = distance[d.value];
					pq.offer(newNode);

				}
			}

			

		}
		return distance;
		
	}

}

class Node {

	int value;
	LinkedList<Node> edges;
	int weight;

	boolean visited;
	boolean processed;

	public Node(int v) {

		this.value = v;

	}

}





class DistanceComparator implements Comparator<Node> {

	@Override
	public int compare(Node n1, Node n2) {
		// TODO Auto-generated method stub

		if (n1.weight > n2.weight)
			return 1;
		else if (n1.weight < n2.weight)
			return -1;
		else
			return 0;

	}

}
