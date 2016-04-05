package marshal.practice.com;

public class MinSwap {

	/*
	 * Complete the function below.
	 */

	public static void minimumSwapsRequired(){
		
		System.out.println(minimumSwapsRequired(3,"GGBBX"));
	}
	
	static int minimumSwapsRequired(int m, String s) {

		char[] arr = s.toCharArray();

		int min_count = Integer.MAX_VALUE;
		int count = 0;
		int bl = 0;
		int gl = 0;
		int br = 0;
		int gr = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 'X') {
				arr[i] = 'G';
			}
		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == 'G') {
				for (int j = i + 1; j < arr.length && gr < m - 1; j++) {

					if (arr[j] == 'G') {
						gr++;
					} else {
						br++;
					}

				}

				for (int j = i - 1; j >= 0 && gl < m - 1; j--) {

					if (arr[j] == 'G') {
						gl++;
					} else {
						bl++;
					}

				}

				if (gl >= m - 1) {

					min_count = min_count > bl ? bl : min_count;
				}

				if (gr >= m - 1) {

					min_count = min_count > br ? br : min_count;
				}

				if (gl + gr >= m - 1 && gl < m - 1 && gr < m - 1) {

					min_count = min_count > (bl + br) ? bl + br : min_count;
				}

				gl = 0;
				gr = 0;
				bl = 0;
				br = 0;

			}

		}
		return min_count;
	}

}
