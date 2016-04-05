package marshal.practice.com;

import java.util.*;

public class CircularTour {

	public static class Trip {
		int petrol;
		int distance;

		public Trip(int p, int d) {
			this.petrol = p;
			this.distance = d;
		}
	}

	public static void getStartingPoint() {

		Trip[] arr = new Trip[3];

		arr[0] = new Trip(4, 4);
		arr[1] = new Trip(8, 6);
		arr[2] = new Trip(1, 3);
		// arr[3] = new Trip(4, 5);

		getStartingPointHelper(arr);

	}

	public static void getStartingPointHelper(Trip[] arr) {

		Trip temp = arr[0];
		int fuel_left = 0;
		int index = -1;

		Queue<Trip> q = new LinkedList<Trip>();

		for (int i = 0; i < arr.length; i++) {
			temp = arr[i];
			temp.petrol += fuel_left;
			if (temp.petrol < temp.distance) {
				q.offer(temp);
				fuel_left = 0;
				// temp=arr[i];
				index = i;
			}

			else {

				fuel_left = temp.petrol - temp.distance;
			}
		}

		while (!q.isEmpty() && temp.petrol >= temp.distance) {

			Trip t = q.poll();

			temp.petrol = temp.petrol - temp.distance + t.petrol;
			temp.distance = t.distance;
		}

		if (q.size() > 0) {
			System.out.println("No tour exist");
		}

		else
			System.out.println(index + 1);

	}

}
