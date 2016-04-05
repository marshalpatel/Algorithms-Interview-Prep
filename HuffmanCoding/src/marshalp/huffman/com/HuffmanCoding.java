package marshalp.huffman.com;

import java.util.PriorityQueue;

public class HuffmanCoding {
	
	
	public static Node getHuffmanTree(Node[] nodeArr){
		
		Node root=null;
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		for(int i = 0;i<nodeArr.length;i++){
			
			pq.offer(nodeArr[i]);
		}
		
		while(pq.size() > 1){
			
			Node n_1 = pq.poll();
			Node n_2 = pq.poll();
			
			Node newNode = new Node('\0', n_1.frequency+n_2.frequency);
			newNode.left = n_1;
			newNode.right = n_2;
			pq.offer(newNode);
			
		}
		
		root = pq.poll();
		return root;
		
	}
	
	public static void printHuffmanCode(Node root, String code){
		
		if(root.left==null && root.right==null){
			
			System.out.println(root.character + " - "+code);
			return;
		}
		
		if(root.left!=null){
			
			printHuffmanCode(root.left, code+"0");
		}
		
		if(root.right!=null){
			printHuffmanCode(root.right, code+"1");
		}
		
		
	}

}
