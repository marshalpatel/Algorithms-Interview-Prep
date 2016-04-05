package marshal.practice.com;

public class SelfCrossing {

	public static void isSelfCrossing() {
		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 10, 4, 4, 3, 3, 2, 2, 1, 1 };

		System.out.println(isSelfCrossing(arr));
	}

	public static boolean isSelfCrossing(int[] x) {

		if (x.length < 4)
			return false;

		for (int i = 3; i < x.length; i++) {
			// left will cut down
			/*
			 * if(i%4==1) { if(x[i-3] >= x[i-1] && x[i-2] <= x[i]) return true;
			 * }
			 * 
			 * if(i%4==3) { if(x[i]>=x[i-2] && x[i-1]<=x[i-3]) return true; }
			 * 
			 * 
			 * //rigth will cut up
			 * 
			 * 
			 * //up will cut left if(i%4==0) { if(x[i-1]<=x[i-3] &&
			 * x[i]>=x[i-2]) return true; }
			 * 
			 * //down will cut right
			 * 
			 * if(i%4==2) { if(x[i-1]<=x[i-3] && x[i]>=x[i-2]) return true; } }
			 */

			System.out.println(x[i]);

			if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2])
				return true;

			else if (i - 5 >= 0 && x[i - 3] >= x[i - 5] && x[i - 2] >= x[i - 4] && x[i-1]<=x[i-3]
					&& (x[i - 1] >= x[i - 3] - x[i - 5])
					&& (x[i] >= x[i - 2] - x[i - 4]))
				return true;

			else if (i - 4 >= 0 && (x[i - 4] + x[i] >= x[i - 2])
					&& (x[i - 1] == x[i - 3]))
				return true;

		}

		return false;

	}
}
