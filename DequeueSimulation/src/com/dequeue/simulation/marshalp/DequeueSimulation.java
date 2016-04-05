package com.dequeue.simulation.marshalp;

import java.util.*;

public class DequeueSimulation {

	static List<String> result = new ArrayList<String>();

	public static void dequeueSim() {

		String out = "2,1,3";
		String[] arr = out.split(",");
		LinkedList<String> outList = new LinkedList<String>();
		ArrayList<String> ops = new ArrayList<String>();
		LinkedList<String> inList = new LinkedList<String>();

		for (int i = 0; i < arr.length; i++) {
			outList.add(arr[i]);
		}

		Arrays.sort(arr);
		int max = Integer.parseInt(arr[arr.length - 1]);

		dequeueSimHelper(inList, 1, outList, max, ops);

		Collections.sort(result);

		if (result.size() > 0)
			System.out.println(result.get(0));

		else
			System.out.println("impossible");

	}

	public static void dequeueSimHelper(LinkedList<String> inList, int counter,
			LinkedList<String> outList, int max, ArrayList<String> ops) {

		if (outList.size() == 0) {
			String operations = "";
			for (String s : ops) {

				operations = operations + s + ",";
			}
			result.add(operations);
			// return;
			return;
		}

		if (counter <= max) {

			// push-back
			ops.add("pushback");
			inList.addLast(String.valueOf(counter));
			dequeueSimHelper(inList, counter + 1, outList, max, ops);
			ops.remove(ops.size() - 1);
			inList.removeLast();

			// push-front
			ops.add("pushfront");
			inList.addFirst(String.valueOf(counter));
			dequeueSimHelper(inList, counter + 1, outList, max, ops);
			ops.remove(ops.size() - 1);
			inList.removeFirst();

		}

		if (outList.peekFirst().equals(inList.peekLast())) {

			String o = outList.removeFirst();
			String i = inList.removeLast();
			ops.add("popback");
			dequeueSimHelper(inList, counter, outList, max, ops);
			outList.addFirst(o);
			inList.addLast(i);
			ops.remove(ops.size() - 1);

		}

	}

}
