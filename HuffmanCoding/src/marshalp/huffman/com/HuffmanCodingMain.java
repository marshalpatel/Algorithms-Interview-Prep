package marshalp.huffman.com;

public class HuffmanCodingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node[] nodes = new Node[6];
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] freqs = { 5, 13, 12, 16, 9, 5 };
		for (int i = 0; i < nodes.length; i++) {

			nodes[i] = new Node(chars[i], freqs[i]);

		}
		
		Node root = HuffmanCoding.getHuffmanTree(nodes);
		
		HuffmanCoding.printHuffmanCode(root, "");

	}

}
