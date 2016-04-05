package marshal.practice.com;

import java.util.*;

public class StockSpanProblem {

	public static void getStockSpan() {

		int[] arr = { 10, 4, 5, 90, 120, 80 };
		getStockSpanHelper(arr);

	}

	public static void getStockSpanHelper(int[] arr) {

		LinkedList<Integer> span = new LinkedList<Integer>();
		LinkedList<Integer> price = new LinkedList<Integer>();
		int[] res = new int[arr.length];
		int count = 0;

		span.push(1);
		price.push(arr[0]);
		res[0] = 1;

		for (int i = 1; i < arr.length; i++) {

			while (!price.isEmpty() && !span.isEmpty() && price.peek() < arr[i]) {
				price.pop();
				count += span.pop();
			}

			res[i] = count + 1;
			price.push(arr[i]);
			span.push(res[i]);
			count = 0;

		}

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

}
