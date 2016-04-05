package marshal.practice.com;

import java.util.*;

public class PrintCombination {

	static ArrayList<Integer> result = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void PrintCombo() {

		int[] arr = { 1, 2, 3 };
		for(int i =1;i<=arr.length;i++)
		PrintComboHelper(arr, 0, i);
		
	}

	public static void PrintComboHelper(int arr[], int start, int r) {

		if (r == 0) {
			for (int i = 0; i < result.size(); i++) {
				System.out.print(result.get(i) + ",");
				

			}
			System.out.println();
			return;
		}

		for (int j = start; j < arr.length; j++) {
			result.add(arr[j]);
			PrintComboHelper(arr, j + 1, r - 1);
			result.remove(result.size() - 1);
		}
	}

}
