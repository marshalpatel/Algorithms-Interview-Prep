package marshal.practice.com;

import java.util.*;

public class MergeKSortedArrays {

	public static void mergeKSortedArrays() {

		int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 25, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		merge(matrix);
	}

	public static void merge(int[][] matrix) {

		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		Element e;
		for (int i = 0; i < matrix.length; i++) {
			pq.offer(new Element(matrix[i][0], i, 0));
		}

		for (int k = 0; k < matrix.length * matrix[0].length; k++) {
			
			e = pq.poll();
			System.out.println(e.value);
			if (e.column+1 < matrix[0].length)
				pq.offer(new Element(matrix[e.row][e.column + 1], e.row,
						e.column + 1));
		}

	}

}
