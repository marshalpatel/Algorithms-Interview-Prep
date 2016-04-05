package marshalp.huffman.com;

public class Node implements Comparable<Node> {

	int frequency;
	char character;
	Node left;
	Node right;

	public Node(char c, int frequency) {
		this.frequency = frequency;
		this.character = c;
	}

	@Override
	public int compareTo(Node n) {
		// TODO Auto-generated method stub

		if (this.frequency > n.frequency)
			return 1;
		else if (this.frequency < n.frequency)
			return -1;
		else
			return 0;

	}
}
