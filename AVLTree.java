package marshal.practice.com;

import java.util.Comparator;

public class AVLTree {

	AVLNode root;

	public int getHeight(AVLNode n) {

		if (n != null)
			return n.height;
		else
			return 0;
	}

	public int getCount(AVLNode n) {

		if (n != null)
			return n.count;
		else
			return 0;
	}

	public int getMax(int a, int b) {

		if (a > b)
			return a;
		else
			return b;
	}

	public AVLNode rotateRight(AVLNode n1) {

		AVLNode a = n1.left;
		AVLNode temp = a.right;

		a.right = n1;
		n1.left = temp;

		n1.height = getMax(getHeight(n1.left), getHeight(n1.right)) + 1;
		a.height = getMax(getHeight(a.left), getHeight(a.right)) + 1;

		n1.count = getCount(n1.left) + getCount(n1.right) + 1;
		a.count = getCount(a.left) + getCount(a.right) + 1;

		return a;

	}

	public AVLNode rotateLeft(AVLNode n1) {

		AVLNode a = n1.right;
		AVLNode temp = a.left;

		a.left = n1;
		n1.right = temp;

		n1.height = getMax(getHeight(n1.left), getHeight(n1.right)) + 1;
		a.height = getMax(getHeight(a.left), getHeight(a.right)) + 1;

		n1.count = getCount(n1.left) + getCount(n1.right) + 1;
		a.count = getCount(a.left) + getCount(a.right) + 1;

		return a;
	}

	public int getBalanceFactor(AVLNode n) {

		if (n != null)
			return getHeight(n.left) - getHeight(n.right);
		else
			return 0;
	}

	public AVLNode insert(AVLNode node, Spaceship s, int index, int[] count) {

		if (node == null)
			return new AVLNode(s);

		if (node.key.endTime > s.endTime) {
			node.left = insert(node.left, s, index, count);
		} else {
			node.right = insert(node.right, s, index, count);

			count[index] = count[index] + 1 + getCount(node.left);
		}

		node.height = getMax(getHeight(node.left), getHeight(node.right)) + 1;
		node.count = getCount(node.left) + getCount(node.right) + 1;

		int bf = getBalanceFactor(node);

		if (bf > 1 && s.endTime < node.left.key.endTime) {
			return rotateRight(node);
		}

		if (bf < -1 && s.endTime > node.right.key.endTime)
			return rotateLeft(node);

		if (bf > 1 && s.endTime > node.left.key.endTime) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}

		if (bf < -1 && s.endTime < node.right.key.endTime) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}

		return node;
	}

	public void getScore(Spaceship[] arr) {

		int[] count = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			this.root = insert(this.root, arr[i], i, count);
			arr[i].score = count[i];
		}

	}

}

class AVLNode {

	Spaceship key;
	AVLNode left;
	AVLNode right;
	int count;
	int height;

	public AVLNode(Spaceship r) {

		this.key = r;
		this.left = null;
		this.right = null;
		this.height = 1;
		this.count = 1;
	}

}

class Spaceship {

	long id;
	long startTime;
	long endTime;
	int score;

	public Spaceship(int id, int s, int e) {

		this.score = 0;
		this.id = id;
		this.startTime = s;
		this.endTime = e;
	}

	

}

class SpaceshipScoreIdComparator implements Comparator<Spaceship> {

	@Override
	public int compare(Spaceship s1, Spaceship s2) {

		if (s1.score > s2.score)
			return 1;
		else if (s1.score < s2.score)
			return -1;

		else {

			if (s1.id > s2.id)
				return 1;
			else
				return -1;
		}
	}

}

class SpaceshipStartTimeComparator implements Comparator<Spaceship> {

	@Override
	public int compare(Spaceship s1, Spaceship s2) {

		if (s1.startTime > s2.startTime)
			return 1;
		else if (s1.startTime < s2.startTime)
			return -1;

		else
			return 0;
	}

}
