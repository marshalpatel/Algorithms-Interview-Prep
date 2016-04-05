package marshal.practice.com;

import java.util.Scanner;

public class Twitter {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		String[] flag = new String[] { "YES", "NO" };
		String line = "";

		while (T > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			boolean f = true;
			String prevLine = null;
			while (N > 0) {
				line = sc.next();
				if (!f) {
					N--;
					continue;
				}
				char a = line.charAt(0);
				if (line.length() < M
						|| line.replaceAll(a + "", "").length() != 0
						|| (prevLine != null && line.contains(prevLine
								.charAt(0) + ""))) {
					f = false;
				}
				prevLine = line;

				N--;
			}
			while (N > 0) {
				line = sc.next();
				N--;
			}
			System.out.println(flag[f ? 0 : 1]);

			T--;
		}

		sc.close();
	}

}
