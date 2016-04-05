package marshal.practice.com;

import java.util.HashMap;
import java.util.HashSet;

class TrieNode {

	char c;
	boolean isLeafNode;
	HashSet<TrieNode> children;
	HashMap<Character, TrieNode> charMap;
	

	public TrieNode(char c) {
		this.c = c;
		this.children = new HashSet<TrieNode>();
		this.charMap = new HashMap<Character, TrieNode>();
		// this.isLeafNode=true;
		this.isLeafNode=false;
	}

	@Override
	public boolean equals(Object obj) {

		TrieNode temp = (TrieNode) obj;

		if (temp instanceof TrieNode && temp.c == this.c)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {

		return this.c;
	}

}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
        char[] charArr = word.toCharArray();

		TrieNode tempNode = this.root;
		HashSet<TrieNode> tempSet = tempNode.children;
		for (int i = 0; i < charArr.length; i++) {

			TrieNode newNode = new TrieNode(charArr[i]);
			if (!tempSet.contains(newNode)) {
				tempSet.add(newNode);
				tempSet = newNode.children;
				tempNode.charMap.put(charArr[i], newNode);
				tempNode = newNode;
				
			} else {

				tempNode = tempNode.charMap.get(newNode.c);
				tempSet = tempNode.children;
			}
			
			if(i==charArr.length-1)
				tempNode.isLeafNode = true;

		}

    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
        char[] charArr = word.toCharArray();

		TrieNode tempNode = this.root;
		HashSet<TrieNode> tempSet = tempNode.children;
		for (int i = 0; i < charArr.length; i++) {

			TrieNode newNode = new TrieNode(charArr[i]);
			if (!tempSet.contains(newNode)) {
				return false;
			} else {
				tempNode = tempNode.charMap.get(newNode.c);
				tempSet = tempNode.children;
			}
		}
		
		if(!tempNode.isLeafNode)
		return false;

else
		return true;

        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String word) {
        
        char[] charArr = word.toCharArray();

		TrieNode tempNode = this.root;
		HashSet<TrieNode> tempSet = tempNode.children;
		for (int i = 0; i < charArr.length; i++) {

			TrieNode newNode = new TrieNode(charArr[i]);
			if (!tempSet.contains(newNode)) {
				return false;
			} else {
				tempNode = tempNode.charMap.get(newNode.c);
				tempSet = tempNode.children;
			}
		}

		return true;

    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");