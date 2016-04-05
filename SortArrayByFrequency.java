package marshal.practice.com;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortArrayByFrequency {

	public static void sortByFrequency() {

		int arr[] = { 2, 5, 2, 8, 3, 8, 8 };
		Arrays.sort(arr);
		sortByFrequencyHelper(arr);
		// PriorityQueue<Elements> pq = new PriorityQueue<Elements>();
		// pq.offer(new Elements(2,5));
		// pq.offer(new Elements(5,2));

		// Elements e;

	}

	public static void sortByFrequencyHelper(int[] arr) {

		Elements temp = new Elements(arr[0], 1);

		PriorityQueue<Elements> pq = new PriorityQueue<Elements>();

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] == arr[i - 1]) {
				temp.count += 1;
			} else {
				pq.offer(temp);
				temp = new Elements(arr[i], 1);
			}

		}

		pq.offer(temp);
		while (!pq.isEmpty()) {

			Elements e = pq.poll();
			int count = e.count;
			while (count >= 1) {
				System.out.println(e.val);
				count--;
			}
		}

	}

}
