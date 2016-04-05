package marshal.practice.com;

import java.util.LinkedList;

public class PoisonousPlants {

	public static void getDays() {

		int[] p = {6 ,5 ,8 ,4 ,7 ,10 ,9};
		int days = 0;
		int right = 0;
		int left = 0;
		int size = 0;

		LinkedList<Integer> main_stack = new LinkedList<Integer>();
		LinkedList<Integer> temp_stack = new LinkedList<Integer>();

		for (int i = 0; i < p.length; i++) {

			main_stack.push(p[i]);
		}

		while (!main_stack.isEmpty()) {

			right = main_stack.pop();
			size = main_stack.size();
			
			while (size > 0) {

				left = main_stack.peek();

				if (right < left) {

					temp_stack.push(right);
				}
				size--;
				right = main_stack.pop();
			}

			while (!temp_stack.isEmpty()) {

				main_stack.push(temp_stack.pop());

			}

			days++;
		}

		System.out.println(days-1);
	}

}
