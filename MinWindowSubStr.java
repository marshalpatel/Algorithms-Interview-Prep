package marshal.practice.com;

import java.util.HashMap;
import java.util.LinkedList;

public class MinWindowSubStr {

	public static String minWindow(String s, String t) {

		if (s.length() == 0 || t.length() == 0)
			return "";

		LinkedList<Character> q = new LinkedList<Character>();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = -1;
		int right = -1;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < t.length(); i++) {
			map.put(t.charAt(i), -1);
		}

		int i = 0;
		int j = 0;

		while (j < s.length()) {

			System.out.println("Processing:" + s.charAt(j));
			if (!map.containsKey(s.charAt(j))) {

				if (q.size() == 0)
					i++;
				j++;
			} else if (map.containsKey(s.charAt(j))) {

				if (q.size() == 0) {
					i = j;
					// q.offer(s.charAt(j));

				}

				int index = map.get(s.charAt(j));
				if (index == -1) {
					q.offer(s.charAt(j));
					map.put(s.charAt(j), j);

					if (q.size() == t.length()) {
						int tl = map.get(q.getFirst());
						int tr = map.get(q.getLast());

						if (tr - tl + 1 < min) {
							left = tl;
							right = tr;
							min = tr - tl + 1;
						}

					}

				} else if (q.size() < t.length()) {
					map.put(s.charAt(j), j);
					q.offer(s.charAt(j));
					if (q.size() == t.length()) {
						int tl = map.get(q.getFirst());
						int tr = map.get(q.getLast());

						if (tr - tl + 1 < min) {
							left = tl;
							right = tr;
							min = tr - tl + 1;
						}

					}

				} else if (q.size() == t.length() && index > -1) {
					while (q.peek() != s.charAt(j)) {

						System.out.println(q.poll());
					}

					System.out.println(q.poll());
					q.offer(s.charAt(j));
					int tempStart = map.get(q.peek());
					int tempEnd = j;
					map.put(s.charAt(j), j);

					if (q.size() == t.length()
							&& (tempEnd - tempStart + 1) < min) {
						min = tempEnd - tempStart + 1;
						left = tempStart;
						right = tempEnd;
					}

				}

				j++;

			}
		}

		int tl = map.get(q.getFirst());
		int tr = map.get(q.getLast());

		if (tr - tl + 1 < min) {
			left = tl;
			right = tr;
		}

		return s.substring(left, right + 1);

	}
}
