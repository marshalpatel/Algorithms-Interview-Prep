package marshal.practice.com;

import java.util.*;

public class FirstNonRepeatingNo {

	class Node {
		int value;

		public Node(int v) {
			this.value = v;
		}

		@Override
		public String toString() {

			return String.valueOf(this.value);
		}
	}

	public static void LinkedListTest() {

		Map<Integer, Node> map = new HashMap<Integer, Node>();
		LinkedList<Node> list = new LinkedList<Node>();
		FirstNonRepeatingNo o = new FirstNonRepeatingNo();
		FirstNonRepeatingNo.Node temp;

		int[] arr = { 2, 1, 3, 2, 3};

		for (int i = 0; i < arr.length; i++) {

			if (map.containsKey(arr[i])) {

				// if(list.contains(o))
				list.remove(map.get(arr[i]));
			} else {

				temp = o.new Node(arr[i]);
				list.offer(temp);
				map.put(temp.value, temp);

			}

		}

		if (list.size() > 0)
			System.out.println(list.getFirst());
		else
			System.out.println("No such element exists");

	}
}
